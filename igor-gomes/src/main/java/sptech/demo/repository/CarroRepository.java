package sptech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.demo.domain.CarroEntity;

public interface CarroRepository extends JpaRepository<CarroEntity, Integer> {
}
