package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.service.CityService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    protected CityService cityService;

    @PostMapping("/add")
    public ServiceResponse addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @GetMapping("/all")
    public List<City> getCities() {
        return cityService.getCities();
    }
}
