package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.repository.CityRepository;
import com.java8.travel_spirit_api.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    protected CityRepository cityRepository;

    @Override
    public List<CityDTO> getForSelect() {
        return cityRepository.getForSelect();
    }

    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public List<City> getCities() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

}
