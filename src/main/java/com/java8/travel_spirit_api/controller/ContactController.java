package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.ContactDTO;
import com.java8.travel_spirit_api.service.ContactService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactController{

    protected ContactService contactService;

    @PostMapping("/add")
    public ServiceResponse addContact(@RequestBody ContactDTO contactDTO) {
        return contactService.addContact(contactDTO);
    }
}
