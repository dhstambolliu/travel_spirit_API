package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.CityDTO;
import com.java8.travel_spirit_api.dto.PackageFilter;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.service.CityService;
import com.java8.travel_spirit_api.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private PackagesService packagesService;
    @Autowired
    private CityService cityService;

    @GetMapping("")
    public List<PackagesDTO> getPackages() {
        return packagesService.getPackages();
    }

    @PostMapping("/search")
    public ResponseEntity<String> search(@RequestBody PackageFilter filter) {
        return packagesService.search();
    }
}
