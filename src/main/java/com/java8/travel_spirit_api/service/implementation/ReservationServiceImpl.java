package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.entity.Reservation;
import com.java8.travel_spirit_api.repository.ReservationRepository;
import com.java8.travel_spirit_api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    private ReservationDTO mapReservationToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservation_date(reservation.getReservationDate());
        reservationDTO.setNumber_of_persons(reservation.getPeople());
        return reservationDTO;
    }

    private Reservation mapDTOToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setReservationDate(reservationDTO.getReservation_date());
        reservation.setPeople(reservationDTO.getNumber_of_persons());
        return reservation;
    }

    @Override
    public void addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = mapDTOToReservation(reservationDTO);
        reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationDTO> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> mapReservationToDTO(reservation)).collect(Collectors.toList());
    }
}
