package com.java8.travel_spirit_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    private int people;
    private String name;
    private String surname;
    private String email;

    @Column(name = "package_id")
    protected Long packageId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable=false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "package_id", insertable = false, updatable=false)
    private Packages packages;
}
