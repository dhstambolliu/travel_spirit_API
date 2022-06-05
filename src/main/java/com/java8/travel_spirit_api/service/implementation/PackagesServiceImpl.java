package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.PackageFilter;
import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.Packages;
import com.java8.travel_spirit_api.repository.PackagesRepository;
import com.java8.travel_spirit_api.service.PackagesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackagesServiceImpl implements PackagesService {
    protected PackagesRepository packagesRepository;

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
        return packages;
    }

    @Override
    public List<PackagesDTO> getFeaturedOffers() {
        List<Packages> packages = packagesRepository.findFeaturedOffers();
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }

    @Override
    public void addPackages(PackagesDTO packagesDTO) {
        Packages packages = mapDTOToPackages(packagesDTO);
        packagesRepository.save(packages);
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
}
