import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Aluno> alunos;

    public Escola(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno a) {
        if (this.alunos.indexOf(a) == -1) {
            alunos.add(a);
            System.out.println(String.format("Aluno: %s Adicionado a lista", a.getNome()));
        } else {
            System.out.println("Aluno já exite");
        }
    }

    public void exibeTodos(){
        for (Aluno a:
                alunos) {
            System.out.println(a);
        }
    }


    public void exibeAlunosGraduacao() {
        for (Aluno a :
                alunos) {
            if (a instanceof AlunoGraduacao)
                System.out.println(a);
        }
    }

    public void exibeAlunosAprovados(){
        for (Aluno a :
                alunos) {
            if (a.calcularMedia() >= 6.0)
                System.out.println(a);
        }
    }

    public void buscarAluno(String ra){
        for (Aluno a :
                alunos) {
            if (a.getRa().equals(ra))
                System.out.println(a);
        }
    }
}
