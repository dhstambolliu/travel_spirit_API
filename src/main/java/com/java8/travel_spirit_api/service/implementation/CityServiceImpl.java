package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.repository.CityRepository;
import com.java8.travel_spirit_api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;


    private CityDTO mapCityToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        return cityDTO;
    }

    private City mapDTOToCity(CityDTO cityDTO) {
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setCountry(cityDTO.getCountry());
        city.setContinent(cityDTO.getContinent());
        return city;
    }
}
