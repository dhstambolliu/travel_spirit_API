package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.entity.Reservation;
import com.java8.travel_spirit_api.repository.ReservationRepository;
import com.java8.travel_spirit_api.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    protected ReservationRepository reservationRepository;

    private ReservationDTO mapReservationToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setPeople(reservation.getPeople());
        reservationDTO.setContact(reservation.getContact());
        reservationDTO.setName(reservation.getName());
        reservationDTO.setSurname(reservation.getSurname());
        reservationDTO.setEmail(reservation.getEmail());
        reservationDTO.setPackageId(reservation.getPackageId());
        return reservationDTO;
    }

    private Reservation mapDTOToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setPeople(reservationDTO.getPeople());
        reservation.setContact(reservationDTO.getContact());
        reservation.setName(reservationDTO.getName());
        reservation.setSurname(reservationDTO.getSurname());
        reservation.setEmail(reservationDTO.getEmail());
        reservation.setPackageId(reservationDTO.getPackageId());
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
