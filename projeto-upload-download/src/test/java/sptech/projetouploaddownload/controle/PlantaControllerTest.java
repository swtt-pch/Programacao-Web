package sptech.projetouploaddownload.controle;

import org.apache.coyote.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import sptech.projetouploaddownload.excecao.PlantaNaoEncontradaException;
import sptech.projetouploaddownload.repositorio.PlantaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = PlantaController.class)
class PlantaControllerTest {

    @Autowired
    private PlantaController controller;
    @MockBean
    private PlantaRepository repository;

    @Test
    @DisplayName("tentativa de atualização do relatório passando um id inválido, que espera que ocorra uma PlantaNaoEncontradaException")
    void patchRelatorio_passando_id_invalido_retorna_PlantaNaoEncontradaException(){
        byte[] relatorio = new byte[1];
        when(repository.existsById(2)).thenReturn(false);
        assertThrows(PlantaNaoEncontradaException.class, () -> controller.patchRelatorio(2, relatorio) );
    }

    @Test
    @DisplayName("tentativa de atualização do relatório passando um id válido e um conteúdo de tamanho inválido, que espera uma ResponseStatusException cujo código de status é 400.")
    void patchRelatorio_conteudo_de_tamanho_invalido_espera_ResponseStatusException_e_status_400(){
        byte[] relatorio = new byte[1];
        when(repository.existsById(2)).thenReturn(true);
        assertThrows(ResponseStatusException.class, () -> controller.patchRelatorio(2, relatorio));
    }

    @Test
    @DisplayName("tentativa de atualização do relatório passando um id válido e um conteúdo de tamanho válido, que espera uma resposta cujo código de status é 200.")
    void patchRelatorio_idPlanta_e_relatorio_valido_retorna_status_200(){
        byte[] relatorio = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        when(repository.existsById(2)).thenReturn(true);
        ResponseEntity<Void> resultado = controller.patchRelatorio(2, relatorio);
        assertEquals(200, resultado.getStatusCodeValue());
    }

}