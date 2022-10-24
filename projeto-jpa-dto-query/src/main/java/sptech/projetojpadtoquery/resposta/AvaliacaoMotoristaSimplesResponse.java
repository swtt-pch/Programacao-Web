package sptech.projetojpadtoquery.resposta;

import java.time.LocalDateTime;

public class AvaliacaoMotoristaSimplesResponse {
    private LocalDateTime dataHoraAvaliacao;
    private Integer nota;
    private int idMotorista;
    private int idPassageiro;

    public AvaliacaoMotoristaSimplesResponse(LocalDateTime dataHoraAvaliacao, Integer nota, int idMotorista, int idPassageiro) {
        this.dataHoraAvaliacao = dataHoraAvaliacao;
        this.nota = nota;
        this.idMotorista = idMotorista;
        this.idPassageiro = idPassageiro;
    }

    public LocalDateTime getDataHoraAvaliacao() {
        return dataHoraAvaliacao;
    }

    public Integer getNota() {
        return nota;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public int getIdPassageiro() {
        return idPassageiro;
    }
}
