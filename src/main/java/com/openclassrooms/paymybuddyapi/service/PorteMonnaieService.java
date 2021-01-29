package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.repository.PorteMonnaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PorteMonnaieService {

    @Autowired
    private PorteMonnaieRepository porteMonnaieRepository ;

    public PorteMonnaie savePorteMonnaie(PorteMonnaie porteMonnaie){
        PorteMonnaie savedPorteMonnaie = porteMonnaieRepository.save(porteMonnaie);
        return savedPorteMonnaie ;
    }
}
