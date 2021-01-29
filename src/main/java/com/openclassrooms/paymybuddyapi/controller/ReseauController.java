package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import com.openclassrooms.paymybuddyapi.service.ReseauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReseauController {

    @Autowired
    private ReseauService reseauService ;


    @PostMapping("/reseau")
    public Reseau addFriend(@RequestBody Reseau reseau){
        return reseauService.saveReseau(reseau) ;
    }
}
