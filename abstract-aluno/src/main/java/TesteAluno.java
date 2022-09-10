public class TesteAluno {

    public static void main(String[] args) {
        Aluno alunoFundamental = new AlunoFundamental("11111", "AlunoFundamental", 8.5,6.5,9.8,7.6);
        Aluno alunoGraduacao = new AlunoGraduacao("22222", "AlunoGraduacao", 8.5,6.5);
        Aluno alunoPos = new AlunoPos("33333", "AlunoPos", 1.0,1.5,1.8);

        System.out.println(alunoFundamental);
        System.out.println(alunoGraduacao);
        System.out.println(alunoPos);

        Escola escola = new Escola("Escola");

        escola.adicionarAluno(alunoFundamental);
        escola.adicionarAluno(alunoFundamental);
        escola.adicionarAluno(alunoGraduacao);
        escola.adicionarAluno(alunoPos);

        System.out.println("EXIBE TODOS");
        escola.exibeTodos();
        System.out.println("EXIBE ALUNOS GRADUACAO");
        escola.exibeAlunosGraduacao();
        System.out.println("EXIBE APROVADOS");
        escola.exibeAlunosAprovados();
        System.out.println("EXIBE ALUNO COM RA 11111");
        escola.buscarAluno("11111");
    }
}
