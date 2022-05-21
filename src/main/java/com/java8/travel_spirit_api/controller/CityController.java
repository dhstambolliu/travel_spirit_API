package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    protected CityService cityService;

}
