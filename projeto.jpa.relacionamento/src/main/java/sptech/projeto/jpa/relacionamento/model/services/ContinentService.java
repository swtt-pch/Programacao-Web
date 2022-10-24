package sptech.projeto.jpa.relacionamento.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sptech.projeto.jpa.relacionamento.model.entity.ContinentEntity;
import sptech.projeto.jpa.relacionamento.repository.ContinentRepository;

@Service
public class ContinentService {
    @Autowired
    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public ContinentEntity getContinentById(int idContinent) {
        return continentRepository.findById(idContinent).orElse(null);
    }
}
