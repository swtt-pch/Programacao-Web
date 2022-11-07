package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.repositorio.PassageiroRepository;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;
import sptech.projetojpadtoquery.resposta.PassageiroSimplesResponse;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PassageiroControllerTest {

    @Autowired
    private PassageiroController controller;

    @MockBean
    private PassageiroRepository repository;

    @Test @DisplayName("retorna lista de motoristas simples e retorna o status 200")
    void retornaSimplesComSucesso(){
        when(repository.getPassageirosSimples()).thenReturn(List.of(
                new PassageiroSimplesResponse(1, "A"),
                new PassageiroSimplesResponse(2, "B")
        ));
        ResponseEntity<List<PassageiroSimplesResponse>> passageiro = controller.getSimples();
        assertEquals(200, passageiro.getStatusCodeValue());
        assertTrue(passageiro.getBody().size() > 0);
    }

    @Test @DisplayName("não retorna lista de motoristas simples e retorna o status 204")
    void retornaSimplesComFalha(){
        when(repository.getPassageirosSimples()).thenReturn(new ArrayList<>());
        ResponseEntity<List<PassageiroSimplesResponse>> passageiro = controller.getSimples();
        assertEquals(204, passageiro.getStatusCodeValue());
        assertNull(passageiro.getBody());
    }
}