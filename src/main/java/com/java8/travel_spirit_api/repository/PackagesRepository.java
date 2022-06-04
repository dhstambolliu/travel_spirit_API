package com.java8.travel_spirit_api.repository;

import com.java8.travel_spirit_api.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagesRepository extends JpaRepository<Packages, Long> {
    @Query("SELECT p FROM Packages p WHERE p.featured = true")
    List<Packages> findFeaturedOffers();

    @Query("SELECT p FROM Packages p WHERE p.name = :name")
    List<Packages> getByName(String name);

    @Query("SELECT p FROM Packages p WHERE (:packageName is not null and p.name like %:packageName%) or (:cityId is not null and p.cityId = :cityId) ")
    List<Packages> search(Long cityId, String packageName);

    @Query("SELECT p FROM Packages p WHERE p.promotionalOffer = true")
    List<Packages> findPromotionalOffers();

    /*@Query("SELECT packages_entity.name, city_entity.name FROM packages_entity p INNER JOIN packages_entity on packages_entity.city = city_entity .name")
    ResponseEntity<String> filter();*/
}

