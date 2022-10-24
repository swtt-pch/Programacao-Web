package sptech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.demo.domain.CarroEntity;

import java.util.List;

public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
    List<CarroEntity> findByFabricanteNome(String nome);
}
