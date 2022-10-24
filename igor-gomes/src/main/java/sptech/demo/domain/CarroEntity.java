package sptech.demo.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "carro")
public class CarroEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarro;
    @NotNull @Size(min = 2, max = 12)
    private String modelo;
    @ManyToOne @JoinColumn(name = "fkFabricante")
    private FabricanteEntity fabricante;
    @PastOrPresent
    private LocalDate dataFabricacao;
    @NotNull @Min(1960) @Max(2021)
    private int anoFabricacao;
    @NotNull @DecimalMin("0.2") @DecimalMax("7.0")
    private double potenciaMotor;

    public Integer getIdCarro() {
        return idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public FabricanteEntity getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteEntity fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public String toString() {
        return "CarroEntity{" +
                "id=" + idCarro +
                ", modelo='" + modelo + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", anoFabricacao=" + anoFabricacao +
                ", potenciaMotor=" + potenciaMotor +
                '}';
    }
}
