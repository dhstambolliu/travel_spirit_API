package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "packages_entity")
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private int duration;
    @Column(name = "promotional_offer")
    private Boolean promotionalOffer;
    @Column(name = "promotional_offer_price")
    private Double promotionalOfferPrice;
    private Boolean featured;
    @Column(name = "image_url")
    private String imageUrl;
    private Boolean active;

    @Column(name = "city_id")
    private Long cityId;

    @ManyToOne
    @JoinColumn(name = "city_id", updatable = false, insertable = false)
    private City city;
}
