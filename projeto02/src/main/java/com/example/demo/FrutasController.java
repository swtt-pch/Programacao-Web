package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutasController {
    private List<String> frutas = new ArrayList<>();

    @GetMapping
    public List<String> getFrutas() {
        return frutas;
    }

    @DeleteMapping("/{indice}") //
    public String excluir(@PathVariable int indice){
        frutas.remove(indice);
        return "Fruta cadastrada";
    }

    @PutMapping("/{indice}")
    public String atualizar(@PathVariable int indice){
        // A fazer
        return "Fruta atualizada";
    }

    @GetMapping("/{indice}")
    public  String getFruta(@PathVariable int indice){
        return  frutas.get(indice);
    }

    @PostMapping
    public String cadastrar(String novaFruta) {
        frutas.add(novaFruta);
        return novaFruta;
    }
}
