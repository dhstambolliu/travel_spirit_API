package com.java8.travel_spirit_api.dto;

import lombok.Data;

@Data
public class CityDTO {
    private Long id;
    private String name;
    private String country;
    private String continent;
}
