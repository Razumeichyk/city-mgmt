package com.sda.springboot.citymgmt.service;

import com.sda.springboot.citymgmt.model.Country;
import com.sda.springboot.citymgmt.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    public List<Country> getCountriesByNameLike(String name){
        return countryRepository.findAllByNameLike(name);
    }

    public List<Country> getCountriesByPopulationGreaterThan(Long population){ return countryRepository.findAllByPopulationGreaterThan(population);}


    public Country saveCountry(Country country){
        return countryRepository.save(country);
    }

    public void deleteCountry(Country country){
        countryRepository.delete(country);
    }

//    public Country getCountryById(Long id) {return countryRepository.findById(id).orElse(null);
//    }

    public Country getCountryByCode(String code) { return countryRepository.getCountryByCode(code);
    }
}
