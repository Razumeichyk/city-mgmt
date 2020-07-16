package com.sda.springboot.citymgmt.controller;

import com.sda.springboot.citymgmt.model.City;
import com.sda.springboot.citymgmt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/web/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ModelAndView getCities(){
        List<City> cityList = cityService.getCities();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cities", cityList);
        modelAndView.setViewName("cityList");
        return modelAndView;
    }

    @GetMapping("/name")
    public ModelAndView getCitiesByName(@RequestParam("cityName") String name){
        ModelAndView modelAndView = new ModelAndView();
        List<City> cityList = cityService.getCitiesByName(name);
        modelAndView.addObject("cities", cityList);
        modelAndView.setViewName("cityList");
        return modelAndView;
    }

    @GetMapping("/id/{cityId}")
    public ModelAndView getCityById(@PathVariable("cityId") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cityView");
        modelAndView.addObject("city", cityService.getCityById(id));
        return modelAndView;
    }

    @GetMapping("/add")
    public String addCity(){
        return "addCity";
    }

    @PostMapping("/add")
    public ModelAndView addCity(City city){
        cityService.saveCity(city);
        ModelAndView mAndV = new ModelAndView();
        mAndV.setViewName("addCity");
        return mAndV;
    }

//    @PostMapping("/add")
//    public String addCity(City city){
//
//        cityService.saveCity(city);
//        return "addCity";
//    }
}
