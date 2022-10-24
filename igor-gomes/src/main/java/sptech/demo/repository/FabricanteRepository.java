package sptech.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.demo.domain.FabricanteEntity;

public interface FabricanteRepository extends JpaRepository<FabricanteEntity, Integer> {
}
