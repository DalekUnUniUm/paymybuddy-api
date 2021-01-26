package com.openclassrooms.paymybuddyapi.utils;

import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckingDataBaseUtils {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    public boolean utilisateurExist(String mail){

        if(utilisateurRepository.findUserByMail(mail) == null)
            return false;

        return true ;
    }

}
