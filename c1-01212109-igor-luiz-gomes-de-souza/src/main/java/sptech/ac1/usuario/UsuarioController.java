package sptech.ac1.usuario;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();

    @PostMapping("/")
    public Usuario postUsuario(@RequestBody Usuario usuario){
        usuarios.add(usuario);
        return usuario;
    }

    @PostMapping("/autenticacao/{usuario}/{senha}")
    public Usuario autenticarUsuario(@PathVariable String usuario,
                                     @PathVariable String senha){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario()) && senha.equals(curUsuario.getSenha())){
                curUsuario.setAutenticado(true);
                return curUsuario;
            }
        }
        return null;
    }

    @GetMapping("/")
    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    @DeleteMapping("/autenticacao/{usuario}")
    public String deleteAutenticacaoUsuario(@PathVariable String usuario){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario())){
                if (curUsuario.isAutenticado()){
                    curUsuario.setAutenticado(false);
                    return String.format("Logoff do usuário %s concluído", curUsuario.getNome());
                }
                return String.format("Usuário %s NÃO está autenticado", curUsuario.getNome());
            }
        }
        return String.format("Usuário %s não encontrado", usuario);
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
    public String atualizarNomeUsuario(@PathVariable String usuario,
                @PathVariable String senha,
                @PathVariable String nome){
        for (Usuario curUsuario : usuarios){
            if (usuario.equals(curUsuario.getUsuario())){
                if (senha.equals(curUsuario.getSenha())){
                    curUsuario.setNome(nome);
                    return String.format("Nome do usuario %s alterado para %s",
                            curUsuario.getUsuario(),
                            curUsuario.getNome());
                }
                return String.format("Senha do usuario %s incorreta", curUsuario.getUsuario());
            }
        }
        return String.format("Usuario %s não encontrado", usuario);
    }
}
