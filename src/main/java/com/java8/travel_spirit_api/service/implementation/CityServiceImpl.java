package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.repository.CityRepository;
import com.java8.travel_spirit_api.service.CityService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
    public ServiceResponse addCity(City city) {

        if (city == null)
            return ServiceResponse.error("Provide the package data");

        if (StringUtils.isAllBlank(city.getName()))
            return ServiceResponse.error("Provide a valid Name");

        if (StringUtils.isAllBlank(city.getContinent()))
            return ServiceResponse.error("Provide a valid Description");

        if (StringUtils.isAllBlank(city.getCountry()))
            return ServiceResponse.error("Provide a valid Image Url");

        cityRepository.save(city);
        return ServiceResponse.success();
    }

    @Override
    public List<City> getCities() {
        List<City> cities = cityRepository.findAll();
        return cities;
    }

}
