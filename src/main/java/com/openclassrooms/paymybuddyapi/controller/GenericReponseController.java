package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.utils.CheckingDataBaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericReponseController {

    @Autowired
    private CheckingDataBaseUtils checkingDataBaseUtils ;

    @RequestMapping(value = "emailExit", method = RequestMethod.GET)
    public int emailExist(@RequestParam("email") String mail){
        if(checkingDataBaseUtils.utilisateurExist(mail) == true){
            return 0 ;
        }

        return 1 ;
    }

}
