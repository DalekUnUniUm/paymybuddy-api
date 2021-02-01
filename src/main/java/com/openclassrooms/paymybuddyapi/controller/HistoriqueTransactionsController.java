package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.service.HistoriqueTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoriqueTransactionsController {

    @Autowired
    private HistoriqueTransactionsService historiqueTransactionsService ;

    @PostMapping("/historique")
    public HistoriqueTransactions createHistorique(@RequestBody HistoriqueTransactions historiqueTransactions){
        return historiqueTransactionsService.saveHistorique(historiqueTransactions);
    }
}
