package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.service.HistoriqueTransactionsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
    public JSONArray getHistoriqueId(@RequestParam("utilisateur_id") int utilisateurId){
        return historiqueTransactionsService.getHistoriqueId(utilisateurId);
    }
    @RequestMapping(value = "/historiques", method = RequestMethod.GET)
    public Iterable<HistoriqueTransactions> getHistoriqueById(@RequestParam("ids") List<Long> ids){
        return historiqueTransactionsService.getHistoriqueById(ids);
    }
}
