package sptech.projeto.jpa.relacionamento.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCountry;
    @Column(length = 25)
    private String name;
    private int population;
    @ManyToOne @JoinColumn(name = "fkContinent")
    private ContinentEntity continent;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getIdPais() {
        return idCountry;
    }

    public ContinentEntity getContinent() {
        return continent;
    }

    public void setContinent(ContinentEntity continent) {
        this.continent = continent;
    }
}
