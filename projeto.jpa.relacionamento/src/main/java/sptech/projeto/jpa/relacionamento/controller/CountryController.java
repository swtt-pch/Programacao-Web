package sptech.projeto.jpa.relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sptech.projeto.jpa.relacionamento.model.entity.CountryEntity;
import sptech.projeto.jpa.relacionamento.model.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getAllContries(){
        List<CountryEntity> countries = countryService.getAllCountries();
        if (countries.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(countries);
    }

    @GetMapping("/{idContinent}")
    public ResponseEntity<List<CountryEntity>> getAllCountriesByContinent(
            @PathVariable int idContinent
    ) {
        List<CountryEntity> countries = countryService.getAllCountriesByCountinent(idContinent);
        if (countries.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(countries);
    }
}
