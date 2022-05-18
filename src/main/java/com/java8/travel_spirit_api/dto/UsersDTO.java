package com.java8.travel_spirit_api.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String username;
    private String password;
}
