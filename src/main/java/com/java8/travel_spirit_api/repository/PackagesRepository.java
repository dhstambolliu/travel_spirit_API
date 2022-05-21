package com.java8.travel_spirit_api.repository;

import com.java8.travel_spirit_api.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagesRepository extends JpaRepository<Packages, Long> {
    @Query("SELECT p FROM packages_entity p WHERE p.promotional_offer = false")
    List<Packages> findPromotionalOffer();

    @Query("SELECT p FROM packages_entity p WHERE p.name = :name")
    List<Packages> getByName(String name);

    @Query("SELECT packages_entity.name, city_entity.name FROM packages_entity p INNER JOIN packages_entity on packages_entity.city_id = city_entity .name")
    ResponseEntity<String> filter();
}
