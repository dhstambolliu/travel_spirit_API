package com.java8.travel_spirit_api.dto;

import lombok.Data;

@Data
public class PackagesDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private int duration;
    private Boolean promotional_offer;
    private Double promotional_offer_price;
    private String image_url;
    private Boolean is_active;
}
