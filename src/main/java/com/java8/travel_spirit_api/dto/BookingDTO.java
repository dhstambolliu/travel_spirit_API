package com.java8.travel_spirit_api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookingDTO {
    private Long id;
    private Date reservationDate;
    private int people;
    private String name;
    private String surname;
    private String email;
    private String contact;
    protected Long packageId;
}
