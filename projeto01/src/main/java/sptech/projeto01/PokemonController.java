package sptech.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    List<String> pokemons = new ArrayList<>();

    @GetMapping
    public String nome(){
        return "Bem vindos à API Pokemons" +
                "<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/International_Pok%C3%A9mon_logo.svg/1200px-International_Pok%C3%A9mon_logo.svg.png\">";
    }

    @GetMapping("/cadastrar/{nome}")
    public String cadastrar(@PathVariable String nome){
        pokemons.add(nome);
        return "Pokemon "+nome+" cadastrado!";
    }

    @GetMapping("/recuperar/{id}")
    public String recuperar(@PathVariable int id){
        if (id > pokemons.size() - 1 || id < 0) return  "Pokemon não cadastrado";

        return pokemons.get(id);

    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id){
        if (id > pokemons.size() - 1 || id < 0) return  "Pokemon não cadastrado";
        String txt = "Pokemon " +pokemons.get(id)+ " excluido";
        pokemons.remove(id);
        return txt;
    }

    @GetMapping("/atualizar/{id}/{novoNome}")
    public String atualizar(@PathVariable int id, @PathVariable String novoNome){
        if (id > pokemons.size() - 1 || id < 0) return  "indice não existe";
        String txt = "Pokemon: " +pokemons.get(id)+ " atualizado para: " + novoNome;
        pokemons.set(id, novoNome);
        return txt;
    }

}
