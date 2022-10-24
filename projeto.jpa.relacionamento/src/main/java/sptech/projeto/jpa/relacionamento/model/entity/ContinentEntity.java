package sptech.projeto.jpa.relacionamento.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "continent")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContinent;

    @Column(length = 25)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdContinent() {
        return idContinent;
    }
}
