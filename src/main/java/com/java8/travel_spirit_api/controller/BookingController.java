package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.BookingDTO;
import com.java8.travel_spirit_api.service.BookingService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

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
        String to = bookingDTO.getEmail();
        String from = "travelspiritagncy@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("travelspiritagncy@gmail.com", "jwdqkktseoshnxjf");
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Booking form status");
            message.setText("Hello " + bookingDTO.getName() + ", your package is booked successfully\n" +
                    "Your email: " + bookingDTO.getEmail() + "\n" +
                    "Your contact number: " + bookingDTO.getContact() + "\n" +
                    "Starting date " + bookingDTO.getReservationDate() + "\n" +
                    "People: " + bookingDTO.getPeople());

            Transport.send(message);
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
        }
        return bookingService.addReservation(bookingDTO);
    }
}
