package com.sda.springboot.citymgmt.controller;

import com.sda.springboot.citymgmt.model.City;
import com.sda.springboot.citymgmt.model.Country;
import com.sda.springboot.citymgmt.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/web/country")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping
    public ModelAndView getCountries(){
        List<Country> countryList = countryService.getAllCountries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countries", countryList);
        modelAndView.setViewName("countryList");
        return modelAndView;
    }


    @GetMapping("/code/{countryCode}")
    public ModelAndView getCountryByCode(@PathVariable("countryCode") String code){
        CityController cityController = new CityController();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("countryView");
        modelAndView.addObject("country", countryService.getCountryByCode(code));
        modelAndView.addObject("country", cityController.getCities());
        return modelAndView;
    }

    @GetMapping("/add")
    public String addCountry(){
        return "addCountry";
    }

    @PostMapping("/add")
    public ModelAndView addCountry(Country country){
        countryService.saveCountry(country);
        ModelAndView mAndV = new ModelAndView();
        mAndV.setViewName("addCountry");
        return mAndV;
    }

//    @PostMapping("/add")
//    public String addCity(City city){
//
//        cityService.saveCity(city);
//        return "addCity";
//    }
}
