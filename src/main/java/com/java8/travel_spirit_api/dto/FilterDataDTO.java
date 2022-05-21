package com.java8.travel_spirit_api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterDataDTO {
    protected List<CityDTO> cities;
}
