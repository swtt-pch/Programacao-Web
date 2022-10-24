package sptech.projeto.jpa.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.projeto.jpa.relacionamento.model.entity.ContinentEntity;
import sptech.projeto.jpa.relacionamento.model.entity.CountryEntity;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    List<CountryEntity> findByContinentIdContinent(int continent);
}
