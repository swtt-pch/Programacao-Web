package sptech.projetouploaddownload.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Planta não encontrada")
public class PlantaNaoEncontradaException extends RuntimeException {
}
