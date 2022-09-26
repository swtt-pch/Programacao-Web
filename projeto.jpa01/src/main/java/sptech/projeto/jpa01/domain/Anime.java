package sptech.projeto.jpa01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Anime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAnime;
    private String nome;
    private LocalDate lancamento;
    private Integer downloads;

    // NÃO PRECISA criar constructor ou toString();
    @JsonIgnore
    public Integer getIdAnime() {
        return idAnime;
    }
    @JsonProperty
    public void setIdAnime(Integer idAnime) {
        this.idAnime = idAnime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public void setLancamento(LocalDate lancamento) {
        this.lancamento = lancamento;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }
}
