package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    protected ReservationService reservationService;

    @GetMapping("")
    public List<ReservationDTO> getReservations() {
        return reservationService.getReservations();
    }

    @PostMapping("/add")
    public void addReservation(@RequestBody ReservationDTO reservationDTO) {
        reservationService.addReservation(reservationDTO);
    }
}
