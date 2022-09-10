public class AlunoPos extends Aluno{

    private double nota1;
    private double nota2;
    private double notaMonografia;

    public AlunoPos(String ra, String nome, double nota1, double nota2, double notaMonografia) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaMonografia = notaMonografia;
    }

    @Override
    public Double calcularMedia() {
        return (nota1 + nota2 + notaMonografia) / 3;
    }

    @Override
    public String toString() {
        return "AlunoPos{" +
                "nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", notaMonografia=" + notaMonografia +
                ", media=" + calcularMedia() +
                "} " + super.toString();
    }
}
