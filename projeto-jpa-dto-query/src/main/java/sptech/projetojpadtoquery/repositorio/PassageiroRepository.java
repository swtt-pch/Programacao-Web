package sptech.projetojpadtoquery.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.projetojpadtoquery.dominio.Motorista;
import sptech.projetojpadtoquery.dominio.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {
}
