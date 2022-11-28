package sptech.projetouploaddownload.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sptech.projetouploaddownload.dominio.Planta;
import sptech.projetouploaddownload.excecao.PlantaNaoEncontradaException;
import sptech.projetouploaddownload.excecao.TamanhoDeArquivoInvalidoException;
import sptech.projetouploaddownload.repositorio.PlantaRepository;

import java.util.List;

@RestController
@RequestMapping("/plantas")
public class PlantaController {

    @Autowired
    private PlantaRepository repository;

    @GetMapping
    public ResponseEntity<List<Planta>> get() {
        List<Planta> plantas = repository.findAll();

        return plantas.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(plantas);
    }

    // atualiza a foto de uma planta
    // "consumes" indica o tipo de dado que será aceito no corpo da requisição
    // o mime-type indicado no "consumes" é image/*, que indica que qualquer imagem será aceita
    // uma lista dos tipos de mime-type está em https://mimetype.io/all-types/ ou em https://www.sitepoint.com/mime-types-complete-list/
    @PatchMapping(value = "/foto/{idPlanta}", consumes = "image/*")
    public ResponseEntity<Void> patchFoto(
            @PathVariable int idPlanta,
            @RequestBody byte[] novaFoto) {
        if (!repository.existsById(idPlanta)) {
            throw new PlantaNaoEncontradaException();
        }

        repository.setFoto(idPlanta, novaFoto);

        return ResponseEntity.status(200).build();
    }

    // recupera a foto de uma planta
    // "produces" indica o tipo de dado que será entregue no corpo da resposta
    // o mime-type indicado no "produces" é image/jpeg (MediaType.IMAGE_JPEG_VALUE), mas, na prática, qualquer imagem funcionará
    // uma lista dos tipos de mime-type está em https://mimetype.io/all-types/ ou em https://www.sitepoint.com/mime-types-complete-list/
    @GetMapping(value = "/foto/{idPlanta}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getFoto(@PathVariable int idPlanta) {
        if (!repository.existsById(idPlanta)) {
            throw new PlantaNaoEncontradaException();
        }

        byte[] foto = repository.getFoto(idPlanta);

        // esse header "content-disposition" indica o nome do arquivo em caso de download em navegador
        return ResponseEntity.status(200).header("content-disposition", "attachment; filename=\"foto-planta.jpg\"").body(foto);
    }

    // atualiza o relátório (planilha excel, formato XLSX) de uma planta
    // "consumes" indica o tipo de dado que será aceito no corpo da requisição
    // o mime-type indicado no "consumes" é arquivo excel com a extensão .xlsx
    // uma lista dos tipos de mime-type está em https://mimetype.io/all-types/ ou em https://www.sitepoint.com/mime-types-complete-list/
    @PatchMapping(value = "/relatorio/{idPlanta}", consumes = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public ResponseEntity<Void> patchRelatorio(@PathVariable int idPlanta, @RequestBody byte[] novaFoto) {
        if (!repository.existsById(idPlanta)) {
            throw new PlantaNaoEncontradaException();
        }
        if (novaFoto.length < 10 || novaFoto.length > 10485760){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Relatório deve conter entre 10b e 10Mb");
        }
        // caso o conteúdo seja um arqui texto (ex: txt, csv)
        // basta converter o byte[] em String
        // String conteudoTexto = new String(novaFoto);

        repository.setFoto(idPlanta, novaFoto);

        return ResponseEntity.status(200).build();
    }

    // recupera o relatório (planilha excel, formato XLSX) de uma planta
    // "produces" indica o tipo de dado que será entregue no corpo da resposta
    // o mime-type indicado no "produces" é arquivo excel com a extensão .xlsx
    // uma lista dos tipos de mime-type está em https://mimetype.io/all-types/ ou em https://www.sitepoint.com/mime-types-complete-list/
    @GetMapping(value = "/relatorio/{idPlanta}", produces = "text/csv")
    public ResponseEntity<byte[]> getRelatorio(@PathVariable int idPlanta) {
        if (!repository.existsById(idPlanta)) {
            throw new PlantaNaoEncontradaException();
        }

        byte[] relatorio = repository.getRelatorio(idPlanta);

        // esse header "content-disposition" indica o nome do arquivo em caso de download em navegador
        return ResponseEntity.status(200).header("content-disposition", "attachment; filename=\"relatorio-planta.xlsx\"").body(relatorio);
    }
}
