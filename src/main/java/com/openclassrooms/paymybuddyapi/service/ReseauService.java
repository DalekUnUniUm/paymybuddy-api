package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.repository.ReseauRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

    /**Endpoint qui permet d'avoir le nombre d'ami selon l'ID de l'utilisateur**/
    public int nbrAmis(int userId){
        return reseauRepository.numberOfFriends(userId,userId);
    }

    /**Endpoint qui permet de savoir si deux personnes sont déjà amis**/
    public int isFriends(int userAId, int userBid){
        return reseauRepository.isFriends(userAId,userBid);
    }

    /**Endpoint qui renvoie la liste des prenoms id**/
    public JSONArray listFriendsFirstName(int utilisateurId){
        return reseauRepository.listFriendsFirstName(utilisateurId);
    }
}