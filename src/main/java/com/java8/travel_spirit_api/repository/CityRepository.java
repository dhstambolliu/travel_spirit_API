package com.java8.travel_spirit_api.repository;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT p FROM City p WHERE p.name = :name")
    List<City> getByName(String name);

    @Query("SELECT p.id as id, p.name as name FROM City p")
    List<CityDTO> getForSelect();
}
