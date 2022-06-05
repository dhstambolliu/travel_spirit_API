package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.service.PackagesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/packages")
public class PackagesController {
    protected PackagesService packagesService;

    @GetMapping("")
    public List<PackagesDTO> getPackages() {
        return packagesService.getPackages();
    }

    @GetMapping("promotional-offers")
    public List<PackagesDTO> getPromotionalOffers() {
        return packagesService.getPromotionalOffers();
    }

    @GetMapping("/carousel")
    public List<PackagesDTO> getFeaturedOffers() {
        return packagesService.getFeaturedOffers();
    }

    @GetMapping("/destinations")
    public List<PackagesDTO> getDestinations() {
        return packagesService.getDestinations();
    }

    @PostMapping("/add")
    public void addPackage(@RequestBody PackagesDTO packagesDTO) {
        packagesService.addPackages(packagesDTO);
    }
}
