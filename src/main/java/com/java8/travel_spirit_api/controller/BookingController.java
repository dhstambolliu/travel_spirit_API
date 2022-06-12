package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.BookingDTO;
import com.java8.travel_spirit_api.service.BookingService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    protected BookingService bookingService;

    @GetMapping("")
    public List<BookingDTO> getReservations() {
        return bookingService.getReservations();
    }

    @PostMapping("/add")
    public ServiceResponse addReservation(@RequestBody BookingDTO bookingDTO) {
        return bookingService.addReservation(bookingDTO);
    }
}
