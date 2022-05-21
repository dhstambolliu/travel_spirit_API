package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "users_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
}
