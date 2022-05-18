package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.entity.Reservation;
import com.java8.travel_spirit_api.repository.ReservationRepository;
import com.java8.travel_spirit_api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    private ReservationDTO mapReservationToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservation_date(reservation.getReservation_date());
        reservationDTO.setNumber_of_persons(reservation.getNumber_of_persons());
        return reservationDTO;
    }

    private Reservation mapDTOToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setReservation_date(reservationDTO.getReservation_date());
        reservation.setNumber_of_persons(reservationDTO.getNumber_of_persons());
        return reservation;
    }
}
