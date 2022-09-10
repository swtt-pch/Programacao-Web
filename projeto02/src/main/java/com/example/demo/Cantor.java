package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cantor {
    @JsonIgnore // esta notação exclui o campo do json
    private String senha;
    private int id;
    private String nome;
    private String categoria;
    private Double cache;
    private boolean contaNoSpotify;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getCache() {
        return cache;
    }

    public boolean isContaNoSpotify() {
        return contaNoSpotify;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCache(Double cache) {
        this.cache = cache;
    }
}
