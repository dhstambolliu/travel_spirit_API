package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getCityByName(String name);
}
