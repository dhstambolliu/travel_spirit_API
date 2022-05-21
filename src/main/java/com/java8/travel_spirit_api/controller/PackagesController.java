package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.entity.Packages;
import com.java8.travel_spirit_api.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackagesController {
    @Autowired
    private PackagesService packagesService;

    @GetMapping("")
    public List<PackagesDTO> getPackages() {
        return packagesService.getPackages();
    }

    @GetMapping("/promotional-offers")
    public List<PackagesDTO> getPromotionalOffers() {
        return packagesService.getPromotionalOffers();
    }

    @PostMapping("/add")
    public void addPackage(@RequestBody PackagesDTO packagesDTO) {
        packagesService.addPackages(packagesDTO);
    }
}
