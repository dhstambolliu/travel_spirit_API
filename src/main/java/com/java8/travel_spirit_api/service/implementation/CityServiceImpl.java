package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.repository.CityRepository;
import com.java8.travel_spirit_api.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    protected CityRepository cityRepository;

/*    private CityDTO mapCityToDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setCountry(city.getCountry());
        cityDTO.setContinent(city.getContinent());
        return cityDTO;
    }*/

    private City mapDTOToCity(CityDTO cityDTO) {
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setCountry(cityDTO.getCountry());
        city.setContinent(cityDTO.getContinent());
        return city;
    }

    @Override
    public List<CityDTO> getForSelect() {
        return cityRepository.getForSelect();
    }

    @Override
    public List<CityDTO> getCityByName(String name) {
        /*List<City> cities = cityRepository.getByName(name);
        return cities.stream().map(city -> mapCityToDTO(city)).collect(Collectors.toList());*/
        return new ArrayList<>();
    }
}
