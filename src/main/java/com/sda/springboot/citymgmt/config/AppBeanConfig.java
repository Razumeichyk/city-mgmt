package com.sda.springboot.citymgmt.config;

import com.sda.springboot.citymgmt.repository.CityRepository;
import com.sda.springboot.citymgmt.service.CityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeanConfig {

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public CityService getCityService(){
//        return new CityService();
//    }
}
