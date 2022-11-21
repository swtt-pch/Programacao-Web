package sptech.projetojpadtoquery.controle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.repositorio.MotoristaRepository;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MotoristaController.class)
class MotoristaControllerTest {
    @Autowired
    private MotoristaController controller;
    @MockBean
    private MotoristaRepository repository;

    @Test @DisplayName("retorna lista de motoristas e retorna o status 200")
    void retornaComSucesso(){
        when(repository.findAll()).thenReturn(List.of(
                new Motorista(),
                new Motorista()
        ));
        ResponseEntity<List<Motorista>> motoristas = controller.get();
        assertEquals(200, motoristas.getStatusCodeValue());
        assertTrue(motoristas.getBody().size() > 0);
    }

    @Test @DisplayName("não retorna lista de motoristas e retorna o status 204")
    void retornaComFalha(){
        when(repository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<Motorista>> motoristas = controller.get();
        assertEquals(204, motoristas.getStatusCodeValue());
        assertNull(motoristas.getBody());
    }

    @Test @DisplayName("retorna lista de motoristas simples e retorna o status 200")
    void retornaSimplesComSucesso(){
        when(repository.getMotoristaSimples()).thenReturn(List.of(
                new MotoristaSimplesResponse(1, "A"),
                new MotoristaSimplesResponse(2, "B")
        ));
        ResponseEntity<List<MotoristaSimplesResponse>> motoristas = controller.getSimples();
        assertEquals(200, motoristas.getStatusCodeValue());
        assertTrue(motoristas.getBody().size() > 0);
    }

    @Test @DisplayName("não retorna lista de motoristas simples e retorna o status 204")
    void retornaSimplesComFalha(){
        when(repository.getMotoristaSimples()).thenReturn(new ArrayList<>());
        ResponseEntity<List<MotoristaSimplesResponse>> motoristas = controller.getSimples();
        assertEquals(204, motoristas.getStatusCodeValue());
        assertNull(motoristas.getBody());
    }

    @Test @DisplayName("delete() deve solicitar a exclusão se o id existir")
    void delete1vez() {
        int idTeste = 12;
        when(repository.existsById(idTeste)).thenReturn(true);
        controller.delete(idTeste);
        verify(repository, times(1)).deleteById(idTeste);
    }
}