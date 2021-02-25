package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Contact;
import com.openclassrooms.paymybuddyapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository ;

    public Contact saveContact(Contact contact){
        Contact savedContact = contactRepository.save(contact);
        return savedContact ;
    }

}
