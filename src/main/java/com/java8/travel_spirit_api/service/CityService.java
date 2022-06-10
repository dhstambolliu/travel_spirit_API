package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;

import java.util.List;

public interface CityService {
    List<CityDTO> getForSelect();

    void addCity(City city);

    List<City> getCities();
}
