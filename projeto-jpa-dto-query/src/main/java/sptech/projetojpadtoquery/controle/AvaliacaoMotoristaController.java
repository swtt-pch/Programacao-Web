package sptech.projetojpadtoquery.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sptech.projetojpadtoquery.dominio.AvaliacaoMotorista;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.excecao.MotoristaNaoExisteException;
import sptech.projetojpadtoquery.excecao.PassageiroNaoExisteException;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.requisicao.NovaAvaliacaoRequest;
import sptech.projetojpadtoquery.resposta.AvaliacaoMotoristaSimplesResponse;
import sptech.projetojpadtoquery.resposta.ResumoAvaliacoesMotoristaResponse;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/avaliacoes/motoristas")
public class AvaliacaoMotoristaController {

    @Autowired
    private AvaliacaoMotoristaRepository avaliacaoMotoristaRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping("/nota-media/{idMotorista}")
    public ResponseEntity<Double> getMediaAvaliacoes(@PathVariable int idMotorista) {
        return ResponseEntity.of(avaliacaoMotoristaRepository.getMediaAvaliacoes(idMotorista));
    }

    @GetMapping("/resumo/{idMotorista}")
    public ResponseEntity<ResumoAvaliacoesMotoristaResponse> getResumoAvaliacoes(@PathVariable int idMotorista) {
        return ResponseEntity.of(avaliacaoMotoristaRepository.getResumoAvaliacoesMotorista(idMotorista));
    }

    @GetMapping("/{idMotorista}")
    public ResponseEntity<List<AvaliacaoMotorista>> getAvaliacaoMotorista(@PathVariable int idMotorista){
        Optional<Motorista> optionalMotorista = motoristaRepository.findById(idMotorista);
        if (!optionalMotorista.isPresent())
            return ResponseEntity.status(404).build();
        List<AvaliacaoMotorista> avaliacoes = avaliacaoMotoristaRepository.findByMotoristaId(idMotorista);
        if (avaliacoes.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(avaliacoes);
    }

    @GetMapping("/{idMotorista}/simples")
    public ResponseEntity<List<AvaliacaoMotoristaSimplesResponse>> getAvaliacaoMotoristaSimples(@PathVariable int idMotorista){
        Optional<Motorista> optionalMotorista = motoristaRepository.findById(idMotorista);
        if (!optionalMotorista.isPresent())
            return ResponseEntity.status(404).build();
        List<AvaliacaoMotoristaSimplesResponse> avaliacoes = avaliacaoMotoristaRepository.getAvaliacaoMotoristaSimples(idMotorista);
        if (avaliacoes.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(avaliacoes);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoMotorista> post(@RequestBody @Valid NovaAvaliacaoRequest novaAvaliacaoRequest) {

       if (!passageiroRepository.existsById(novaAvaliacaoRequest.getIdPassageiro())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Passageiro não encontrado");
       }
       if (!motoristaRepository.existsById(novaAvaliacaoRequest.getIdMotorista())) {
            throw new MotoristaNaoExisteException();
       }

        AvaliacaoMotorista novaAvaliacao = new AvaliacaoMotorista();

        novaAvaliacao.setPassageiro(
                passageiroRepository.findById(novaAvaliacaoRequest.getIdPassageiro()).orElseThrow(PassageiroNaoExisteException::new));
        novaAvaliacao.setMotorista(
                motoristaRepository.findById(novaAvaliacaoRequest.getIdMotorista()).orElseThrow(MotoristaNaoExisteException::new));

        novaAvaliacao.setNota(novaAvaliacaoRequest.getNota());

        avaliacaoMotoristaRepository.save(novaAvaliacao);

        return ResponseEntity.status(201).body(novaAvaliacao);
    }
}
