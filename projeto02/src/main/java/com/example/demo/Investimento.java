package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public class Investimento {
    private UUID id = UUID.randomUUID();
    private String nome;
    private Double minimo;
    private Double juroAnuais;
    private boolean aberto;


    public String getNome() {
        return nome;
    }

    public Double getMinimo() {
        return minimo;
    }

    public Double getJuroAnuais() {
        return juroAnuais;
    }

    public boolean isAberto() {
        return aberto;
    }

    public UUID getId() {
        return id;
    }
}
