package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.service.PorteMonnaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PorteMonnaieController {

    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    /**Endpoint qui permet la création d'un porte monnaie lors de l'enregistrement d'une personne**/
    @PostMapping("/wallet")
    public PorteMonnaie createPorteMonnaie(@RequestBody PorteMonnaie porteMonnaie){
        return porteMonnaieService.savePorteMonnaie(porteMonnaie);
    }


}
