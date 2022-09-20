package template;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.yaml.snakeyaml.introspector.Property;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private double precoUnitario;
    private double quantidadeEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public double getValorEmEstoque() {
        return quantidadeEstoque * precoUnitario;
    }

}
