package sptech.ac1.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/")
    public ResponseEntity postUsuario(@RequestBody Usuario usuario){
        if (usuario.getNome()==null || usuario.getNome().length() < 3){
            return ResponseEntity.status(400).body("Nome deve ter 3 ou mais caracteres");
        }
        if (usuario.getSenha()==null || usuario.getSenha().length()<3){
            return  ResponseEntity.status(400).body("A senha deve ter 3 ou mais caracteres");
        }
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public ResponseEntity autenticarUsuario(@PathVariable String usuario,
                                     @PathVariable String senha){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario())){
                if (senha.equals(curUsuario.getSenha())){
                    curUsuario.setAutenticado(true);
                    return ResponseEntity.status(202).body(curUsuario);
                }
                return ResponseEntity.status(401).body("Senha incorreta");
            }
        }
        return ResponseEntity.status(404).body("Usuario não encontrado");
    }

    @GetMapping("/")
    public ResponseEntity getUsuarios(){
        if (usuarios.size() == 0){
            return ResponseEntity.status(204).body("Nenhum usuario cadastrado");
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public ResponseEntity deleteAutenticacaoUsuario(@PathVariable String usuario){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario())){
                if (curUsuario.isAutenticado()){
                    curUsuario.setAutenticado(false);
                    return ResponseEntity.status(200).body(String.format("Logoff do usuário %s concluído",
                            curUsuario.getNome()));
                }
                return ResponseEntity.status(401).body(String.format("Usuário %s NÃO está autenticado", curUsuario.getNome()));
            }
        }
        return ResponseEntity.status(404).body(String.format("Usuário %s não encontrado", usuario));
    }


    /**
     *
     * @param usuario
     * @param senha
     * @param nome
     * Função responsável por atualizar o nome do usuário
     * @return String com informação sobre a atualização
     */
    @PatchMapping("/atualizar/{usuario}/{senha}/{nome}")
    public ResponseEntity atualizarNomeUsuario(@PathVariable String usuario,
                @PathVariable String senha,
                @PathVariable String nome){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario())){
                if (senha.equals(curUsuario.getSenha())){
                    curUsuario.setNome(nome);
                    return ResponseEntity.status(200).body(String.format("Nome do usuario %s alterado para %s",
                            curUsuario.getUsuario(),
                            curUsuario.getNome()));
                }
                return ResponseEntity.status(401).body(String.format("Senha do usuario %s incorreta", curUsuario.getUsuario()));
            }
        }
        return ResponseEntity.status(404).body(String.format("Usuario %s não encontrado", usuario));
    }
}
