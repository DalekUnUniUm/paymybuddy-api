package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import com.openclassrooms.paymybuddyapi.service.ReseauService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReseauController {

    @Autowired
    private ReseauService reseauService ;

    /**Endpoint qui permet d'avoir le nombre d'ami selon l'ID de l'utilisateur**/
    @GetMapping("/reseau/nbrFriends")
    public int nbrAmi(@RequestParam("userId") int userId){
        return reseauService.nbrAmis(userId);
    }

    /**Endpoint qui permet de savoir si deux personnes sont déjà amis**/
    @GetMapping("/reseau/isFriends")
    public int isFriends(@RequestParam("userAId") String userAId, @RequestParam("userBId") String userBId){
        return reseauService.isFriends(userAId,userBId);
    }
    @GetMapping("/reseau/listFriendsFirstName")
    public JSONObject listFriendsFirstName(@RequestParam("utilisateur_id") int utilisateurId){
        JSONObject listFriend = new JSONObject();

        listFriend.put("firstName",reseauService.listFriendsFirstName(utilisateurId));

        return listFriend;
    }
    @PostMapping("/reseau")
    public Reseau addFriend(@RequestBody Reseau reseau){
        return reseauService.saveReseau(reseau) ;
    }

}
