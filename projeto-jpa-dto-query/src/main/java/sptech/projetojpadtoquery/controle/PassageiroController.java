package sptech.projetojpadtoquery.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.projetojpadtoquery.dominio.Passageiro;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {
    @Autowired
    private PassageiroRepository repository;

    @GetMapping("/simples")
    public ResponseEntity<List<PassageiroSimplesResponse>> getSimples() {
        return ResponseEntity.status(200).body(repository.getPassageirosSimples());
    }

    @DeleteMapping("/{idPassageiro}") @Transactional
    public ResponseEntity setPassageiroSuspenso(@PathVariable int idPassageiro){
        Optional<Passageiro> optionalPassageiro = repository.findById(idPassageiro);
        if (!optionalPassageiro.isPresent())
            return ResponseEntity.status(404).build();
        optionalPassageiro.get().setSuspenso(true);
        return ResponseEntity.status(200).build();
    }
}
