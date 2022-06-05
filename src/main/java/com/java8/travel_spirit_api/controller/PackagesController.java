package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.PackageFilter;
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

    @PostMapping("/destinations")
    public List<PackagesDTO> getDestinations(@RequestBody PackageFilter dto) {
        return packagesService.getDestinations(dto);
    }

    @PostMapping("/add")
    public void addPackage(@RequestBody PackagesDTO packagesDTO) {
        packagesService.addPackages(packagesDTO);
    }
}
