package sptech.projetojpadtoquery.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Passageiro não existe")
public class PassageiroNaoExisteException extends RuntimeException{
}
