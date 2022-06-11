package com.java8.travel_spirit_api.controller;

import com.java8.travel_spirit_api.dto.ContactDTO;
import com.java8.travel_spirit_api.service.ContactService;
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
    public void addContact(@RequestBody ContactDTO contactDTO) {
        contactService.addContact(contactDTO);
    }
}
