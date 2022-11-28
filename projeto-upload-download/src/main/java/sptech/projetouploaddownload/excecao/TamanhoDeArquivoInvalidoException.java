package sptech.projetouploaddownload.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Relatório deve conter entre 10b e 10Mb")
public class TamanhoDeArquivoInvalidoException extends RuntimeException{
}
