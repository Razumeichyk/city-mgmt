package com.sda.springboot.citymgmt.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Country {
    @Id
    private String code;
    private String name;
    private String continent;
    private String region;
    private Long population;

    @OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
    private List<City> cities;
}
