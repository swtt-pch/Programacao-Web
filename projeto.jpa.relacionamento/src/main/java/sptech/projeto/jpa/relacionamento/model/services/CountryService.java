package sptech.projeto.jpa.relacionamento.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sptech.projeto.jpa.relacionamento.model.entity.ContinentEntity;
import sptech.projeto.jpa.relacionamento.model.entity.CountryEntity;
import sptech.projeto.jpa.relacionamento.repository.CountryRepository;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    @Autowired
    private final ContinentService continentService;

    public CountryService(CountryRepository countryRepository, ContinentService continentService) {
        this.countryRepository = countryRepository;
        this.continentService = continentService;
    }

    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<CountryEntity> getAllCountriesByCountinent(int idContinent) {
        return countryRepository.findByContinentIdContinent(idContinent);
    }
}
