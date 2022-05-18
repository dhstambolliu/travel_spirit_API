package com.java8.travel_spirit_api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CustomException {
    private String name;
    private String error;
    private LocalDate localDate;
}
