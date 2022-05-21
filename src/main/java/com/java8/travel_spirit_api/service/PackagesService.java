package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.PackagesDTO;

import java.util.List;

public interface PackagesService {
    List<PackagesDTO> getPromotionalOffers();

    void addPackages(PackagesDTO packagesDTO);

    List<PackagesDTO> getPackages();
}
