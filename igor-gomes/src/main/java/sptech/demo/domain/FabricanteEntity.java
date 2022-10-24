package sptech.demo.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fabricante")
public class FabricanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFabricante;
    @Size(max = 15)
    private String nome;

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
