package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.NewsletterDTO;
import com.java8.travel_spirit_api.service.NewsletterService;
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
@RequestMapping("/newsletter")
public class NewsletterController {

    protected NewsletterService newsletterService;

    @GetMapping()
    public List<NewsletterDTO> getSubscriptions() {
        return newsletterService.getSubscriptions();
    }

    @PostMapping("/add")
    public ServiceResponse addNewsletter(@RequestBody NewsletterDTO newsletterDTO) {
        String to = newsletterDTO.getEmail();
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
            message.setText("Hello " + newsletterDTO.getEmail() + ", you are successfully subscribed");

            Transport.send(message);
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
        }
        return newsletterService.addNewsletter(newsletterDTO);
    }

}
