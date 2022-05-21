package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/search/{name}")
    public List<CityDTO> searchCityByName(@PathVariable("name") String name) {
        return cityService.getCityByName(name);
    }
}
