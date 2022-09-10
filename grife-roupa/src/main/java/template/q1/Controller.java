package template.q1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("grifes")
public class Controller {

    List<Grife> grifes = new ArrayList<>();

    @PostMapping("/")
    public Grife postGrife(@RequestBody Grife grife){
        grifes.add(grife);
        System.out.println(grife.getChaveAcesso());
        return grife;
    }

    @GetMapping("/")
    public List<Grife> getGrifes(){
        return grifes;
    }

    @PutMapping("/{posicao}")
    public Grife putGrife(@RequestBody Grife grife, @PathVariable int posicao){
        if (grifes.size() == 0 || grifes.size() - 1 < posicao) return null;
        grifes.set(posicao, grife);
        return grifes.get(posicao);
    }

    @DeleteMapping("/{posicao}")
    public String deleteGrife(@PathVariable int posicao){
        if (grifes.size() == 0 || grifes.size() - 1 < posicao) return "Não encontrada";
        grifes.remove(posicao);
        return "Grife excluída";
    }
}
