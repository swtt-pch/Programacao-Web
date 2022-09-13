package sptech.projeto3.Frutas;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutaController {
    private List<Fruta> frutas = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Fruta>> getFruta(){
        if (frutas.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(frutas);
    }

    @PostMapping("/favorita")
    public ResponseEntity<Fruta> favorita(){
        Fruta fruta = new Fruta("Morango", 10.00);
        frutas.add(fruta);
        return ResponseEntity.status(201).body(fruta);
    }

    // Get /frutas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Fruta> getFruta(@PathVariable int id){
        if (id >= frutas.size() || id < 0) return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(frutas.get(id));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Fruta novaFruta){
        if (novaFruta.getNome() == null || novaFruta.getNome().isBlank()){
            return ResponseEntity.status(400).body("Nome deve ser 1+ letras");
        }
        if (novaFruta.getPreco()!=null && novaFruta.getPreco() < 0.00) {
            return ResponseEntity.status(400).body("Preço deve ser maior ou igual a zero");
        }

        frutas.add(novaFruta);
        return ResponseEntity.status(201).body(novaFruta);
    }
}
