package com.java8.travel_spirit_api.dto;

import lombok.Data;

@Data
public class PackagesDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private int duration;
    private Boolean promotionalOffer;
    private Double promotionalOfferPrice;
    private String imageUrl;
    private Boolean active;
    private Boolean featured;
}
