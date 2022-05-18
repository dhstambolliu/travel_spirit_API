package com.java8.travel_spirit_api.repository;

import com.java8.travel_spirit_api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
