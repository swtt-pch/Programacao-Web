package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse;

import java.util.List;

public interface MotoristaRepository extends JpaRepository<Motorista, Integer> {
    @Query("SELECT new sptech.projetojpadtoquery.resposta.MotoristaSimplesResponse(mot.id, mot.nome) FROM Motorista mot where mot.suspenso=false")
    List<MotoristaSimplesResponse> getMotoristaSimples();
}
