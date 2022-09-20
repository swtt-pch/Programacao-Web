package template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    List<Produto> produtos = new ArrayList<>();

    @PostMapping("/")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
        if (produto.getNome() == null ||
                produto.getQuantidadeEstoque() == 0.0 ||
                produto.getPrecoUnitario() == 0.0){
            return ResponseEntity.status(401).build();
        }
        if (produto.getNome().length() < 2) {
            return ResponseEntity.status(401).build();
        }
        if (produto.getPrecoUnitario() <= 0.0 || produto.getQuantidadeEstoque() <= 0.0){
            return ResponseEntity.status(401).build();
        }
        produtos.add(produto);
        return ResponseEntity.status(201).body(produto);
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> getProdutos(){
        if (produtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtos);
    }

    @DeleteMapping("/{posicao}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable int posicao){
        if (posicao < 0 || posicao > produtos.size() - 1) {
            return  ResponseEntity.status(404).build();
        }
        Produto produto = produtos.get(posicao);
        produtos.remove(posicao);
        return ResponseEntity.status(200).body(produto);
    }
}
