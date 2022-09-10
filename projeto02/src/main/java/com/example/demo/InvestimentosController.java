package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentosController {
    private List<Investimento> investimentos = new ArrayList<>();

    @GetMapping // metodo: get / URI: /investimentos
    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    @PostMapping // metodo: POST / URI: /investimentos
    public Investimento postInvestimento(@RequestBody Investimento novoInvestimento){
        investimentos.add(novoInvestimento);
        return novoInvestimento;
    }

    /*
    Método: Put
    URI: /investimentos/{posicao}
    JSON de Investimentos no corpo de requisicao
        - Atualiza o investimento na posição indicada com os dados do JSON enviado.
     */

    @PutMapping("/{posicao}")
    public Investimento putInvestimento(@RequestBody Investimento investimento, @PathVariable int posicao){
        investimentos.set(posicao, investimento);
        return investimentos.get(posicao);
    }

    @GetMapping("/{posicao}")
    public Investimento getInvestimento(@PathVariable int posicao) {
        return investimentos.get(posicao);
    }

    @DeleteMapping("/{posicao}")
    public String deleteInvestimento(@PathVariable int posicao) {
        investimentos.remove(posicao);
        return "Removido com sucesso";
    }
}
