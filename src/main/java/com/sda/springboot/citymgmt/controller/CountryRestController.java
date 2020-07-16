package com.sda.springboot.citymgmt.controller;


import com.sda.springboot.citymgmt.model.Country;
import com.sda.springboot.citymgmt.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {

    @Autowired
    private CountryService countryService;

    //@RequestMapping("/country")
    @GetMapping
    //@ResponseBody
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    //localhost:8080/country/name?name=Angola
    @GetMapping("/name")
    public List<Country> getCountriesByName(@RequestParam("name") String name){
        return countryService.getCountriesByNameLike(name);
    }

    //localhost:8080/country/name/Angola
    @GetMapping("/nameLike/{name}")
    List<Country> getCountriesByNameLike(@PathVariable("name") String name) {
        return countryService.getCountriesByNameLike(name);
    }

    @GetMapping("/populationgt/{population}")
    public List<Country> getCountriesByPopulationGreaterThen(@PathVariable("population") Long population){
        return countryService.getCountriesByPopulationGreaterThan(population);
    }

    @PostMapping
    public Country saveCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @DeleteMapping
    public void deleteCountry(@RequestBody Country country) { countryService.deleteCountry(country);}
}
