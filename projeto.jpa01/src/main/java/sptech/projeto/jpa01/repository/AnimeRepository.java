package sptech.projeto.jpa01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.projeto.jpa01.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

}
