package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    void addReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getReservations();
}
