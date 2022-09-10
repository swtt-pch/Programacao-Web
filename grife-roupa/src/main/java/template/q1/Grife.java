package template.q1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Grife {
    private String nome;
    private int anoCriacao;
    private double valorAcaoBolsa;
    private String chaveAcesso;

    public String getNome() {
        return nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public double getValorAcaoBolsa() {
        return valorAcaoBolsa;
    }

    @JsonIgnore
    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public void setValorAcaoBolsa(double valorAcaoBolsa) {
        this.valorAcaoBolsa = valorAcaoBolsa;
    }

    @JsonProperty
    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }
}
