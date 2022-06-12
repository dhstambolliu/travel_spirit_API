package com.java8.travel_spirit_api.service;

import com.java8.travel_spirit_api.dto.ContactDTO;
import com.java8.travel_spirit_api.utils.ServiceResponse;

public interface ContactService {

    ServiceResponse addContact(ContactDTO contactDTO);
}
