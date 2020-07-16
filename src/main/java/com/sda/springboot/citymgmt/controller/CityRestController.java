package com.sda.springboot.citymgmt.controller;

import com.sda.springboot.citymgmt.model.City;
import com.sda.springboot.citymgmt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    @Autowired
    private CityService cityService;

    //@RequestMapping("/city")
    @GetMapping
    //@ResponseBody
    public List<City> getCities(){
        return cityService.getCities();
    }

    //localhost:8080/city/name?name=London
    @GetMapping("/name")
    public List<City> getCitiesByName(@RequestParam("name") String name){
        return cityService.getCitiesByName(name);
    }

    //localhost:8080/city/name/London
    @GetMapping("/name/{cityName}")
    public List<City> getCitiesByName2(@PathVariable("cityName") String name){
        return cityService.getCitiesByName(name);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable("id") Long id){
        return cityService.getCityById(id);
    }

    @GetMapping("/countrycode/{countryCode}")
    public List<City> getCitiesByCountryCode(@PathVariable ("countryCode") String code){
        return cityService.getCitiesByCountryCode(code);
    }

    @GetMapping("/countrycode/{countryCode}/name/{name}")
    public List<City> getCitiesByCountryCodeAndName(@PathVariable("countryCode") String countryCode,
                                                    @PathVariable("name") String name){
        return cityService.getCitiesByCountryCodeAndName(countryCode, name);
    }

    @GetMapping("/populationgt/{population}")
    public List<City> getCityByPopulationGreaterThen(@PathVariable("population") Long population){
        return cityService.getCityByPopulationGreaterThan(population);
    }

    @GetMapping("/pop/{population}/dist/{district}")
    public List<City> getCitiesByPopulationAndDistrict(@PathVariable("population") Long population,
                                                       @PathVariable("district") String district){
        return cityService.getCitiesByPopulationAndDistrict(population, district);
    }

    @PostMapping
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @DeleteMapping
    public void deleteCity(@RequestBody City city) { cityService.deleteCity(city);}

//    @PostMapping
//    public City deleteCity(@RequestBody City city){}

//    @RequestMapping("/citypage")
//    public String goToSamplePage(){
//        return "sample";
//    }
}
