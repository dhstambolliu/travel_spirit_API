package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.PackageFilter;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.Packages;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PackagesService {
    List<PackagesDTO> getFeaturedOffers();

    void addPackages(PackagesDTO packagesDTO);

    List<PackagesDTO> getPackages();

    List<PackagesDTO> getPackageByName(String name);

    ResponseEntity<List<Packages>> search(PackageFilter filter);

    List<PackagesDTO> getPromotionalOffers();

    List<PackagesDTO> getDestinations();
}
