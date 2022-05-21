package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.PackagesDTO;
import com.java8.travel_spirit_api.entity.Packages;
import com.java8.travel_spirit_api.entity.Subscribe;
import com.java8.travel_spirit_api.repository.PackagesRepository;
import com.java8.travel_spirit_api.service.PackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackagesServiceImpl implements PackagesService {

    @Autowired
    private PackagesRepository packagesRepository;


    private PackagesDTO mapPackagesToDTO(Packages packages) {
        PackagesDTO packagesDTO = new PackagesDTO();
        packagesDTO.setId(packages.getId());
        packagesDTO.setName(packages.getName());
        packagesDTO.setDescription(packages.getDescription());
        packagesDTO.setDuration(packages.getDuration());
        packagesDTO.setIs_active(packages.getIs_active());
        packagesDTO.setPrice(packages.getPrice());
        packagesDTO.setImage_url(packages.getImage_url());
        packagesDTO.setPromotional_offer(packages.getPromotional_offer());
        packagesDTO.setPromotional_offer_price(packages.getPromotional_offer_price());
        return packagesDTO;
    }

    private Packages mapDTOToPackages(PackagesDTO packagesDTO) {
        Packages packages = new Packages();
        packages.setId(packagesDTO.getId());
        packages.setName(packagesDTO.getName());
        packages.setDescription(packagesDTO.getDescription());
        packages.setDuration(packagesDTO.getDuration());
        packages.setIs_active(packagesDTO.getIs_active());
        packages.setPrice(packagesDTO.getPrice());
        packages.setImage_url(packagesDTO.getImage_url());
        packages.setPromotional_offer(packagesDTO.getPromotional_offer());
        packages.setPromotional_offer_price(packagesDTO.getPromotional_offer_price());
        return packages;
    }

    @Override
    public List<PackagesDTO> getPromotionalOffers() {
        List<Packages> packages = packagesRepository.findPromotionalOffer();
        return packages.stream().map(packg -> mapPackagesToDTO(packg)).collect(Collectors.toList());
    }
}
