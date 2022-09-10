package sptech.ac1.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
    private String usuario;
    private String senha;
    private String nome;
    private boolean autenticado = false;

    public boolean isAutenticado() {
        return autenticado;
    }

    public String getUsuario() {
        return usuario;
    }

    @JsonIgnore
    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @JsonProperty
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
