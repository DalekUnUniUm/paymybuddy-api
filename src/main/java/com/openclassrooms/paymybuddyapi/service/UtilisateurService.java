package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    public Optional<Utilisateur> getUtilisateur(final long id){
        return utilisateurRepository.findById(id);
    }

    public Iterable<Utilisateur> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur ;
    }
    public String loginUser(String mail, String password){
        return utilisateurRepository.findIdByMailAndPwd(mail,password);
    }
    /**Cet endpoint permet de récupérer l'Id d'un utilisateur selon mail**/
    public String findIdByMail(String mail){
        return utilisateurRepository.findIdByMail(mail);
    }

    public String utilisateurIdByName(String firstName){
        return utilisateurRepository.utilisateurIdByName(firstName);
    }

    public String soldesIdByUserId(String utilisateurId){
        return utilisateurRepository.soldesIdByUserId(utilisateurId);
    }

    public String firstNameByUserId(String utilisateurId){
        return utilisateurRepository.firstNameByUserId(utilisateurId);
    }

}
