package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.PackageFilter;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.entity.Packages;
import com.java8.travel_spirit_api.repository.CityRepository;
import com.java8.travel_spirit_api.repository.PackagesRepository;
import com.java8.travel_spirit_api.service.PackagesService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackagesServiceImpl implements PackagesService {
    protected PackagesRepository packagesRepository;

    protected CityRepository cityRepository;

    private PackagesDTO mapPackagesToDTO(Packages packages) {
        PackagesDTO packagesDTO = new PackagesDTO();
        packagesDTO.setId(packages.getId());
        packagesDTO.setName(packages.getName());
        packagesDTO.setDescription(packages.getDescription());
        packagesDTO.setDuration(packages.getDuration());
        packagesDTO.setActive(packages.getActive());
        packagesDTO.setPrice(packages.getPrice());
        packagesDTO.setImageUrl(packages.getImageUrl());
        packagesDTO.setPromotionalOffer(packages.getPromotionalOffer());
        packagesDTO.setPromotionalOfferPrice(packages.getPromotionalOfferPrice());
        packagesDTO.setFeatured(packages.getFeatured());
        packagesDTO.setCityId(packages.getCityId());
        return packagesDTO;
    }

    private Packages mapDTOToPackages(PackagesDTO packagesDTO) {
        Packages packages = new Packages();
        packages.setId(packagesDTO.getId());
        packages.setName(packagesDTO.getName());
        packages.setDescription(packagesDTO.getDescription());
        packages.setDuration(packagesDTO.getDuration());
        packages.setActive(packagesDTO.getActive());
        packages.setPrice(packagesDTO.getPrice());
        packages.setImageUrl(packagesDTO.getImageUrl());
        packages.setPromotionalOffer(packagesDTO.getPromotionalOffer());
        packages.setPromotionalOfferPrice(packagesDTO.getPromotionalOfferPrice());
        packages.setFeatured(packagesDTO.getFeatured());
        packages.setCityId(packagesDTO.getCityId());
        return packages;
    }

    @Override
    public List<PackagesDTO> getFeaturedOffers() {
        List<Packages> packages = packagesRepository.findFeaturedOffers();
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public ServiceResponse addPackages(PackagesDTO packagesDTO) {
        if (packagesDTO == null)
            return ServiceResponse.error("Provide the package data");

        if (StringUtils.isAllBlank(packagesDTO.getName()))
            return ServiceResponse.error("Provide a valid Name");

        if (packagesDTO.getCityId() == null)
            return ServiceResponse.error("Provide a valid City");

        if (StringUtils.isAllBlank(packagesDTO.getDescription()))
            return ServiceResponse.error("Provide a valid Description");

        if (StringUtils.isAllBlank(packagesDTO.getImageUrl()))
            return ServiceResponse.error("Provide a valid Image Url");

        City dbCity = cityRepository.getById(packagesDTO.getCityId());
        if (dbCity == null)
            return ServiceResponse.error("City not found in database");

        Packages packages = mapDTOToPackages(packagesDTO);
        packagesRepository.save(packages);
        return ServiceResponse.success();
    }

    @Override
    public List<PackagesDTO> getPackages() {
        List<Packages> packages = packagesRepository.findAll();
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public List<PackagesDTO> getPackageByName(String name) {
        List<Packages> packages = packagesRepository.getByName(name);
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<List<Packages>> search(PackageFilter filter) {

        return new ResponseEntity(packagesRepository.search(filter.getCityId(), filter.getPackageName()), HttpStatus.OK);
    }

    @Override
    public List<PackagesDTO> getPromotionalOffers() {
        List<Packages> packages = packagesRepository.findPromotionalOffers();
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public List<PackagesDTO> getDestinations(PackageFilter dto) {
        List<Packages> packages = packagesRepository.getDestinations(dto.getQuery());
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public List<PackagesDTO> getBookingPackage(Long id) {
        List<Packages> packages = packagesRepository.getBookingPackage(id);
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }
}
