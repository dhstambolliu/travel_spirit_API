package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.FilterDataDTO;
import com.java8.travel_spirit_api.dto.PackageFilter;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.Packages;
import com.java8.travel_spirit_api.service.CityService;
import com.java8.travel_spirit_api.service.PackagesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {

    protected PackagesService packagesService;
    protected CityService cityService;

    @GetMapping("")
    public List<PackagesDTO> getPackages() {
        return packagesService.getPackages();
    }

    @GetMapping("/filter-data")
    public FilterDataDTO getFilterData() {


        FilterDataDTO response = FilterDataDTO.builder()
                .cities(cityService.getForSelect())
                .build();

        return response;
    }

    @PostMapping("/search")
    public ResponseEntity<List<Packages>> search(@RequestBody PackageFilter filter) {
        return packagesService.search(filter);
    }
}
