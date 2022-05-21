package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("")
    public List<ReservationDTO> getReservations() {
        return reservationService.getReservations();
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.addReservation(reservationDTO);
    }
}
