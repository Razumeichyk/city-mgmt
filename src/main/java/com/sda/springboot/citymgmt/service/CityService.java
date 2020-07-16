package com.sda.springboot.citymgmt.service;

import com.sda.springboot.citymgmt.model.City;
import com.sda.springboot.citymgmt.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public List<City> getCitiesByName(String name){
        return cityRepository.findAllByName(name);
    }

    public City getCityById(Long id){
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> getCitiesByCountryCode(String countryCode){
        return cityRepository.findAllByCountryCode(countryCode);
    }

    public List<City> getCitiesByCountryCodeAndName(String countryCode, String name){
        return cityRepository.findAllByCountryCodeAndName2(countryCode,name);
    }

    public List<City> getCityByPopulationGreaterThan(Long population){ return cityRepository.findAllByPopulationGreaterThan(population);}

    public List<City> getCitiesByPopulationAndDistrict(Long population, String district){
        return cityRepository.findAllByDistrictPopulationGreaterThan(population, district);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public void deleteCity(City city){
        cityRepository.delete(city);
    }
}
