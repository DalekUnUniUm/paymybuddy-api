package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.service.HistoriqueTransactionsService;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoriqueTransactionsController {

    @Autowired
    private HistoriqueTransactionsService historiqueTransactionsService ;

    @PostMapping("/historique")
    public HistoriqueTransactions createHistorique(@RequestBody HistoriqueTransactions historiqueTransactions){
        return historiqueTransactionsService.saveHistorique(historiqueTransactions);
    }
    /**Endpoint qui permet de récupérer l'historique des transactions**/
    @GetMapping("/historique/myHistorique")
    public JSONArray getHistorique(@RequestParam("utilisateur_id") int utilisateurId){
        return historiqueTransactionsService.getHistorique(utilisateurId);
    }
}
