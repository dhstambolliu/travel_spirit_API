package com.java8.travel_spirit_api.dto;

import lombok.Data;

@Data
public class SubscribeDTO {
    private Long id;
    private String email;
    private Boolean is_active;
}
