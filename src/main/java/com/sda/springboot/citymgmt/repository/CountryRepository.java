package com.sda.springboot.citymgmt.repository;

import com.sda.springboot.citymgmt.model.Country;
import com.sda.springboot.citymgmt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findAllByNameLike(String name);
    List<Country> findAllByPopulationGreaterThan(Long population);

    Country getCountryByCode(String code);
}
