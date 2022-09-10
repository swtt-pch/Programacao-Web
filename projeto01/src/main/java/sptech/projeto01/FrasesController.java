package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// @RestController -> Isso é uma anotação (annotation)
// Essa anotação indica que a classe sera uma controladora REST. Ou seja, ela poderá ter endpoints
@RestController
public class FrasesController {

    // Essa anotação transforma o método anotado em uma chamada da API REST do projeto
    @GetMapping
    public String comprimentar() {
        return String.format("<h1>Hello world! 😁</h1>" +
                       "<a href=\"http://localhost:8080/despedida\" >despedida</a><br><br>"+
                "<a href=\"http://localhost:8080/elogio\" >elogio</a>") ;
    }

    @GetMapping("/despedida")
    public String despedir() {
        return String.format("<h1>Bye world... 😢</h1>" +
                "<a href=\"http://localhost:8080/\" >comprimento</a> <br><br>"+
                "<a href=\"http://localhost:8080/elogio\" >elogio</a>") ;
    }

    @GetMapping("/elogio")
    public String elogiar() {
        return String.format("<h1>Você é maneiro... 😍</h1>" +
                "<a href=\"http://localhost:8080/\" >comprimento</a><br><br>"+
                "<a href=\"http://localhost:8080/despedida\" >despedida</a>") ;
    }

    @GetMapping("/soma/{a}/{b}")
    public String somar(@PathVariable Integer a, @PathVariable Integer b){
        return String.format("%d + %d = %d", a, b, a+b);
    }

    @GetMapping("/maior/{n1}/{n2}")
    public String maior(@PathVariable Double n1,
                        @PathVariable Double n2) {
        return n1 > n2 ? String.format("O número %s é maior que o número %s", n1, n2) : String.format("O número %s é maior que o número %s", n2, n1);
    }

    @GetMapping("/sorteio/{n}")
    public String sorteio(@PathVariable int n) {

        int random = (int)Math.floor(Math.random()*10);
        return random == n ? "Parabéns, que sorte!" : "#deuruim";
    }
}
