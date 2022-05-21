package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "rating_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int rating;

    @Column(name = "user_id")
    protected Long userId;

    @Column(name = "package_id")
    protected Long packageId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable=false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "package_id", insertable = false, updatable=false)
    private Packages packages;
}
