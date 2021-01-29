package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import com.openclassrooms.paymybuddyapi.repository.ReseauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReseauService {

    @Autowired
    private ReseauRepository reseauRepository ;

    public Reseau saveReseau(Reseau reseau){
        Reseau savedReseau = reseauRepository.save(reseau);
        return savedReseau ;
    }
}
