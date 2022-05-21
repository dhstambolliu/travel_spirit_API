package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "subscribe_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private Boolean active;
}
