package sptech.demo.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.demo.domain.CarroEntity;
import sptech.demo.repository.CarroRepository;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import java.util.List;

@RestController @RequestMapping("carros")
public class CarroController {
    @Autowired
    private final CarroRepository carroRepository;

    public CarroController(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @PostMapping
    public ResponseEntity<CarroEntity> cadastrarCarro( @Valid @RequestBody CarroEntity carro){
        if (carro == null)
            return ResponseEntity.status(400).build();
        carroRepository.save(carro);
        return ResponseEntity.status(201).body(carro);
    }
    @GetMapping("/todos")
    public ResponseEntity<List<CarroEntity>> getCarros(){
        List<CarroEntity> carros = carroRepository.findAll();
        if (carros.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(carros);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarroEntity> getCarro(@PathVariable Integer id){
        CarroEntity carro = carroRepository.findById(id).get();
        if (carro == null)
            return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(carro);
    }

    @GetMapping
    public ResponseEntity<List<CarroEntity>> getCarroByFabricante(
            @RequestParam(required = false) String fabricante
    ) {

        List<CarroEntity> carros =
                fabricante == null ? carroRepository.findAll() :
        carroRepository.findByFabricanteNome(fabricante);
        if (carros.isEmpty())
            return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(carros);
    }
}
