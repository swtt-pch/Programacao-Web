package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private List<Heroi> ArrayList;
    private List<Heroi> herois  = new ArrayList<Heroi>(List.of(
            new Heroi("Heroi A", "Andar", 100.0, true),
            new Heroi("Heroi B", "Ler", 600.0, true),
            new Heroi("Heroi C", "Interpretar", 900.0, true),
            new Heroi("Heroi D", "Falar", 1200.0, true)
    ));

    @GetMapping("/favorito")
    public Heroi heroiFavorito(){
        Heroi favorito = new Heroi ("Lanterna-verde", "Emular", 100.00, true);
        return favorito;
    }

    @GetMapping
    public List<Heroi> getHerois() {
        return herois;
    }

    @GetMapping("/{indice}")
    public Heroi heroiPorIndice(@PathVariable int indice) {
        if (indice < 0 || indice >= herois.size()) return null;

        return herois.get(indice);
    }

    @GetMapping("/cadastrar/{nome}/{poder}/{forca}/{vivo}")
    public Heroi cadastrar(@PathVariable String nome,
                           @PathVariable String poder,
                           @PathVariable double forca,
                           @PathVariable boolean vivo){
        Heroi heroi = new Heroi(nome, poder,forca, vivo);
        System.out.println(heroi);
        herois.add(heroi);
        return heroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{poder}/{forca}/{vivo}")
    public Heroi cadastrar(@PathVariable String nome,
                           @PathVariable String poder,
                           @PathVariable double forca,
                           @PathVariable boolean vivo,
                           @PathVariable int indice ){
        if (indice < 0 || indice >= herois.size()) return null;
        Heroi heroi = new Heroi(nome, poder,forca, vivo);
        herois.set(indice, heroi);
        return heroi;
    }
}
