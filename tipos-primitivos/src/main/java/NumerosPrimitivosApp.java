public class NumerosPrimitivosApp {
    public static void main(String[] args) {
        Teste t1 = new Teste();
        System.out.println("Altura: " + t1.altura);

        t1.altura = 2.2;
        System.out.println("Altura: " + t1.altura);

        TestePrimitivos tp = new TestePrimitivos();

        System.out.println("Altura: " + tp.altura);
        System.out.println("Quantidade de pessoas: " + tp.qtdPessoas);
        System.out.println("Está chuvendo : " + tp.estaChuvendo);

        // a linha abaixo não compila
        //double imc = null;

        //int filhos;
        //System.out.println(filhos); // erro: variável não foi inicializada


    }
}
