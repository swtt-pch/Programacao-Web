package sptech.projetouploaddownload.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;


    @JsonIgnore // ignoramos no JSON pois não faz sentido retorna um vetor de bytes num JSON!
    @Column(length = 50 * 1024 * 1024) // 50 Mega Bytes
    private byte[] foto;

    @JsonIgnore // ignoramos no JSON pois não faz sentido retorna um vetor de bytes num JSON!
    @Column(length = 10 * 1024 * 1024) // 10 Mega Bytes
    private byte[] relatorioExcel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getRelatorioExcel() {
        return relatorioExcel;
    }

    public void setRelatorioExcel(byte[] relatorioExcel) {
        this.relatorioExcel = relatorioExcel;
    }
}
