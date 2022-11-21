package sptech.projetojpadtoquery.controle;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaRepository repository;

    @GetMapping("")
    public ResponseEntity<List<Motorista>> get(){
        List<Motorista> motoristas = repository.findAll();
        if (motoristas.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(motoristas);
    }

    @GetMapping("/simples")
    public ResponseEntity<List<MotoristaSimplesResponse>> getSimples(){
        List<MotoristaSimplesResponse> motoristaSimplesResponses = repository.getMotoristaSimples();
        if (motoristaSimplesResponses.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(motoristaSimplesResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
