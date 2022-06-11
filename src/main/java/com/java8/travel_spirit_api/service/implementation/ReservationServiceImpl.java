package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ReservationDTO;
import com.java8.travel_spirit_api.entity.City;
import com.java8.travel_spirit_api.entity.Reservation;
import com.java8.travel_spirit_api.repository.ReservationRepository;
import com.java8.travel_spirit_api.service.ReservationService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
    public ServiceResponse addReservation(ReservationDTO reservationDTO) {

        if (reservationDTO == null)
            return ServiceResponse.error("Provide the reservation data");

        if (StringUtils.isAllBlank(reservationDTO.getName()))
            return ServiceResponse.error("Provide a valid Name");

        if (StringUtils.isAllBlank(reservationDTO.getSurname()))
            return ServiceResponse.error("Provide a valid Surname");

        if (StringUtils.isAllBlank(reservationDTO.getEmail()))
            return ServiceResponse.error("Provide a valid Email");

        if (reservationDTO.getPeople() < 1) {
            return ServiceResponse.error("Select number of people");
        }

        if (StringUtils.isAllBlank((CharSequence) reservationDTO.getReservationDate()))
            return ServiceResponse.error("Select a Starting Date");

        if (StringUtils.isAllBlank(reservationDTO.getContact()))
            return ServiceResponse.error("Provide a valid Contact Number");


        Reservation dbReservation = reservationRepository.getById(reservationDTO.getPackageId());
        if (dbReservation == null)
            return ServiceResponse.error("Package not found in database");

        Reservation reservation = mapDTOToReservation(reservationDTO);
        reservationRepository.save(reservation);
        return ServiceResponse.success();
    }

    @Override
    public List<ReservationDTO> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservation -> mapReservationToDTO(reservation)).collect(Collectors.toList());
    }
}
