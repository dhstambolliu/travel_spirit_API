package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ContactDTO;
import com.java8.travel_spirit_api.entity.Contact;
import com.java8.travel_spirit_api.repository.ContactRepository;
import com.java8.travel_spirit_api.service.ContactService;
import com.java8.travel_spirit_api.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    protected ContactRepository contactRepository;

    private ContactDTO mapContactsToDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setFullName(contact.getFullName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setSubject(contact.getSubject());
        return contactDTO;
    }

    private Contact mapDTOToContacts(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setFullName(contactDTO.getFullName());
        contact.setEmail(contactDTO.getEmail());
        contact.setSubject(contactDTO.getSubject());
        return contact;
    }

    @Override
    public ServiceResponse addContact(ContactDTO contactDTO) {

        if (contactDTO == null)
            return ServiceResponse.error("Provide the info data");

        if (StringUtils.isAllBlank(contactDTO.getFullName()))
            return ServiceResponse.error("Provide a valid Name");

        if (StringUtils.isAllBlank(contactDTO.getEmail()))
            return ServiceResponse.error("Provide a valid email");

        if (StringUtils.isAllBlank(contactDTO.getSubject()))
            return ServiceResponse.error("Provide a valid subject");

        Contact contact = mapDTOToContacts(contactDTO);
        contactRepository.save(contact);
        return ServiceResponse.success();
    }
}
