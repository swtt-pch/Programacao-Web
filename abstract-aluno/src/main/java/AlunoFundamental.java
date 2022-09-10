public class AlunoFundamental extends Aluno{

    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public AlunoFundamental(String ra, String nome, double nota1, double nota2, double nota3, double nota4) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    @Override
    public Double calcularMedia() {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    @Override
    public String toString() {
        return "AlunoFundamental{" +
                "nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", nota4=" + nota4 +
                ", media=" + calcularMedia() +
                "} " + super.toString();
    }
}
