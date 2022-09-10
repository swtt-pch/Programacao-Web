package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cantores")
public class CantoresController {

    private List<Cantor> cantores = new ArrayList<>();

    @PostMapping
    public Cantor postCantor(@RequestBody Cantor cantor){
        cantor.setId(cantores.size() + 1);
        cantores.add(cantor);
        return cantor;
    }

    @GetMapping("/{id}")
    public Cantor getCantor(@PathVariable int id){
        if (cantores.size() == 0) return null;
        for (Cantor cantor:
             cantores) {
            if (cantor.getId() == id) return cantor;
        }
        return null;
    }

    @GetMapping("/celebridades")
    public List<Cantor> getCelebridades(){
        List<Cantor> celebridades = new ArrayList<>();
        for (Cantor cantor : cantores){
            if (cantor.getCache() > 100_000){
                celebridades.add(cantor);
            }
        }
        return celebridades;
    }

    @PutMapping("/{id}")
    public Cantor putCantor(@RequestBody Cantor novoCantor, @PathVariable int id){
        for (Cantor cantor : cantores){
            if (cantor.getId() == id) {
                cantor.setNome(novoCantor.getNome());
                cantor.setCache(novoCantor.getCache());
                return cantor;
            }
        }
        return null;
    }

}
