package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "packages_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private int duration;
    private Boolean promotional_offer;
    private Double promotional_offer_price;
    private Boolean is_featured;
    private String image_url;
    private Boolean is_active;
    @ManyToOne
    private City city_id;
}
