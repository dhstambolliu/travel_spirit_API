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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "reservation_date")
    private Date reservationDate;

    private int people;


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
