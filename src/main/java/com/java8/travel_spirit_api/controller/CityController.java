package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    protected CityService cityService;

    @PostMapping("/add")
    public void addCity(@RequestBody City city) {

        cityService.addCity(city);
    }

    @GetMapping("/all")
    public List<City> getCities() {
        return cityService.getCities();
    }
}
