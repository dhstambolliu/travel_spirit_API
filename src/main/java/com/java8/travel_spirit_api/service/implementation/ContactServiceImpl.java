package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.ContactDTO;
import com.java8.travel_spirit_api.entity.Contact;
import com.java8.travel_spirit_api.repository.ContactRepository;
import com.java8.travel_spirit_api.service.ContactService;
import lombok.AllArgsConstructor;
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
    public void addPackages(ContactDTO contactDTO) {
        Contact contact = mapDTOToContacts(contactDTO);
        contactRepository.save(contact);
    }

    @Override
    public void addContact(ContactDTO contactDTO) {
        Contact contact = mapDTOToContacts(contactDTO);
        contactRepository.save(contact);
    }
}
