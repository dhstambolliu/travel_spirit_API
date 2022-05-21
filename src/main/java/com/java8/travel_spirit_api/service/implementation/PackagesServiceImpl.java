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
        packagesDTO.setIs_active(packages.getActive());
        packagesDTO.setPrice(packages.getPrice());
        packagesDTO.setImage_url(packages.getImageUrl());
        packagesDTO.setPromotional_offer(packages.getPromotionalOffer());
        packagesDTO.setPromotional_offer_price(packages.getPromotionalOfferPrice());
        return packagesDTO;
    }

    private Packages mapDTOToPackages(PackagesDTO packagesDTO) {
        Packages packages = new Packages();
        packages.setId(packagesDTO.getId());
        packages.setName(packagesDTO.getName());
        packages.setDescription(packagesDTO.getDescription());
        packages.setDuration(packagesDTO.getDuration());
        packages.setActive(packagesDTO.getIs_active());
        packages.setPrice(packagesDTO.getPrice());
        packages.setImageUrl(packagesDTO.getImage_url());
        packages.setPromotionalOffer(packagesDTO.getPromotional_offer());
        packages.setPromotionalOfferPrice(packagesDTO.getPromotional_offer_price());
        return packages;
    }

    @Override
    public List<PackagesDTO> getPromotionalOffers() {
        List<Packages> packages = packagesRepository.findPromotionalOffer();
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
}
