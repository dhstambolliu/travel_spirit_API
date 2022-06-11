package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.utils.ServiceResponse;

import java.util.List;

public interface ReservationService {
    ServiceResponse addReservation(ReservationDTO reservationDTO);

    List<ReservationDTO> getReservations();
}
