package sptech.projetojpadtoquery.servico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("calcularPrecoCorrida() deve calcular corretamente")
    void calcularPrecoCorrida_deveCalcularCorretamente() {
        CalculadoraService service = new CalculadoraService();
        double result = service.calcularPrecoCorrida(2.0);
        assertEquals(24, result);
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção para kilometragem errada")
    void calcularPrecoCorrida_kmInvalido(){
        CalculadoraService service = new CalculadoraService();
        assertThrows(ResponseStatusException.class, () -> service.calcularPrecoCorrida(-3.5));
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção para kilometragem nula")
    void calcularPrecoCorrida_kmNulo(){
        CalculadoraService service = new CalculadoraService();
        assertThrows(ResponseStatusException.class, () -> service.calcularPrecoCorrida(null));
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção para kilometragem errada")
    void calcularPrecoCorrida_kmInvalida_detalhes(){
        CalculadoraService service = new CalculadoraService();
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, ()-> service.calcularPrecoCorrida(-3.5));
        assertEquals("Distância deve ser >= 0", exception.getReason());
        assertEquals(400, exception.getRawStatusCode());
    }

    @Test
    @DisplayName("calcularPrecoCorrida() deve lançar exceção para kilometragem nula")
    void calcularPrecoCorrida_kmNula_detalhes(){
        CalculadoraService service = new CalculadoraService();
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, ()-> service.calcularPrecoCorrida(null));
        assertEquals("Não pode ser nulo", exception.getReason());
        assertEquals(400, exception.getRawStatusCode());
    }

    @Test
    @DisplayName("CalculadoraService está anotada com @Service")
    void testarAnotacaoCalculadoraService() {
        Class<CalculadoraService> classEx = CalculadoraService.class;
        assertTrue(classEx.isAnnotationPresent(Service.class), "Anotação não encontrada");
    }
}