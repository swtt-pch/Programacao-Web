package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import sptech.projetojpadtoquery.dominio.AvaliacaoMotorista;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.dominio.Passageiro;
import sptech.projetojpadtoquery.excecao.MotoristaNaoExisteException;
import sptech.projetojpadtoquery.repositorio.AvaliacaoMotoristaRepository;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.requisicao.NovaAvaliacaoRequest;

import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AvaliacaoMotoristaControllerTest {
    @Autowired
    private AvaliacaoMotoristaController controller;

    @MockBean
    private AvaliacaoMotoristaRepository repository;
    @MockBean
    private PassageiroRepository passageiroRepository;
    @MockBean
    private MotoristaRepository motoristaRepository;


    @Test
    @DisplayName("Verifica média avaliação presente")
    void mediaAvaliacaoExiste() {
        when(repository.getMediaAvaliacoes(anyInt())).thenReturn(Optional.of(25.0));
        ResponseEntity<Double> mediaAvaliacoes = controller.getMediaAvaliacoes(1);
        assertEquals(200, mediaAvaliacoes.getStatusCodeValue());
        assertEquals(25.0, mediaAvaliacoes.getBody());
    }
    @Test
    @DisplayName("Verifica média avaliação não está presente")
    void mediaAvaliacaoNaoExiste() {
        when(repository.getMediaAvaliacoes(anyInt())).thenReturn(Optional.empty());
        ResponseEntity<Double> mediaAvaliacoes = controller.getMediaAvaliacoes(1);
        assertEquals(404, mediaAvaliacoes.getStatusCodeValue());
        assertNull(mediaAvaliacoes.getBody());
    }

    @Test
    @DisplayName("Retorna ResponseStatusException caso o passageiro não exista")
    void passageiroNaoExiste(){
        when(passageiroRepository.existsById(anyInt())).thenReturn(false);
        when(motoristaRepository.existsById(anyInt())).thenReturn(true);
        assertThrows(ResponseStatusException.class, () -> controller.post(new NovaAvaliacaoRequest()) );
    }

    @Test
    @DisplayName("Retorna MotoristaNaoExisteException caso o motorista não exista")
    void motoristaNaoExiste(){
        when(passageiroRepository.existsById(anyInt())).thenReturn(true);
        when(motoristaRepository.existsById(anyInt())).thenReturn(false);
        assertThrows(MotoristaNaoExisteException.class, () -> controller.post(new NovaAvaliacaoRequest()));
    }

    @Test
    @DisplayName("Retorna status 201, corpo notnull e nota igual a passada se correto")
    void avaliacaoFeita(){
        when(passageiroRepository.existsById(anyInt())).thenReturn(true);
        when(motoristaRepository.existsById(anyInt())).thenReturn(true);
        when(passageiroRepository.findById(anyInt())).thenReturn(Optional.of(new Passageiro()));
        when(motoristaRepository.findById(anyInt())).thenReturn(Optional.of(new Motorista()));
        ResponseEntity<AvaliacaoMotorista> avaliacaoMotoristaResponseEntity = controller.post(new NovaAvaliacaoRequest(1,1,5));
        assertEquals(201, avaliacaoMotoristaResponseEntity.getStatusCodeValue());
        assertEquals(AvaliacaoMotorista.class, avaliacaoMotoristaResponseEntity.getBody().getClass());
        assertEquals(5, avaliacaoMotoristaResponseEntity.getBody().getNota());
    }
}