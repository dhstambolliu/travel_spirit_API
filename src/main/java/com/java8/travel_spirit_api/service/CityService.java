package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.utils.ServiceResponse;

import java.util.List;

public interface CityService {
    List<CityDTO> getForSelect();

    ServiceResponse addCity(City city);

    List<City> getCities();
}
