package sptech.projeto.jpa.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.projeto.jpa.relacionamento.model.entity.ContinentEntity;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Integer> {

}
