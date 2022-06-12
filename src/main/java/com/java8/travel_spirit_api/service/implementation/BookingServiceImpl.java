package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.BookingDTO;
import com.java8.travel_spirit_api.entity.Booking;
import com.java8.travel_spirit_api.repository.BookingRepository;
import com.java8.travel_spirit_api.service.BookingService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    protected BookingRepository bookingRepository;

    private BookingDTO mapReservationToDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setReservationDate(booking.getReservationDate());
        bookingDTO.setPeople(booking.getPeople());
        bookingDTO.setContact(booking.getContact());
        bookingDTO.setName(booking.getName());
        bookingDTO.setSurname(booking.getSurname());
        bookingDTO.setEmail(booking.getEmail());
        bookingDTO.setPackageId(booking.getPackageId());
        return bookingDTO;
    }

    private Booking mapDTOToReservation(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setReservationDate(bookingDTO.getReservationDate());
        booking.setPeople(bookingDTO.getPeople());
        booking.setContact(bookingDTO.getContact());
        booking.setName(bookingDTO.getName());
        booking.setSurname(bookingDTO.getSurname());
        booking.setEmail(bookingDTO.getEmail());
        booking.setPackageId(bookingDTO.getPackageId());
        return booking;
    }

    @Override
    public ServiceResponse addReservation(BookingDTO bookingDTO) {

        if (bookingDTO == null)
            return ServiceResponse.error("Provide the reservation data");

        if (StringUtils.isAllBlank(bookingDTO.getName()))
            return ServiceResponse.error("Provide a valid Name");

        if (StringUtils.isAllBlank(bookingDTO.getSurname()))
            return ServiceResponse.error("Provide a valid Surname");

        if (StringUtils.isAllBlank(bookingDTO.getEmail()))
            return ServiceResponse.error("Provide a valid Email");

        if (bookingDTO.getPeople() < 1) {
            return ServiceResponse.error("Select number of people");
        }

        if (StringUtils.isAllBlank(bookingDTO.getContact()))
            return ServiceResponse.error("Provide a valid Contact Number");


        Booking dbBooking = bookingRepository.getById(bookingDTO.getPackageId());
        if (dbBooking == null)
            return ServiceResponse.error("Package not found in database");

        Booking booking = mapDTOToReservation(bookingDTO);
        bookingRepository.save(booking);
        return ServiceResponse.success();
    }

    @Override
    public List<BookingDTO> getReservations() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map(booking -> mapReservationToDTO(booking)).collect(Collectors.toList());
    }
}
