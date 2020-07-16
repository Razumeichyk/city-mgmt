package com.sda.springboot.citymgmt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @Column(name = "countrycode")
//    private String countryCode;
    private String district;
    private Long population;
    @ManyToOne
    @JoinColumn(name = "countryCode")
    private Country country;
}
