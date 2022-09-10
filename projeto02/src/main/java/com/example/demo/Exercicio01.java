package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class Exercicio01 {

    @GetMapping("/pode-votar/{idade}")
    public boolean podeVotar(@PathVariable int idade) {
        return idade >= 16;
    }

    @GetMapping("/imc/{peso}/{altura}")
    public double imc(@PathVariable double peso, @PathVariable double altura){
        return peso / (Math.pow(altura, 2));
    }

    @GetMapping("/analise-campanha/{vit}/{emp}/{der}")
    public String analiseCampanha(@PathVariable int vit,@PathVariable int emp,@PathVariable int der){
        double total = (vit+ emp + der) * 3;
        double pontos = (vit * 3) + emp;
        return String.format("A campanha do time foi de %.2f%%", (pontos / total * 100));
    }
}
