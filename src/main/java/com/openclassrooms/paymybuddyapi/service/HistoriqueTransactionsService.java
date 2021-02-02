package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.repository.HistoriqueTransactionsRepository;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueTransactionsService {

    @Autowired
    private HistoriqueTransactionsRepository historiqueTransactionsRepository ;

    public HistoriqueTransactions saveHistorique(HistoriqueTransactions historiqueTransactions){
        HistoriqueTransactions savedHistoriqueTransaction = historiqueTransactionsRepository.save(historiqueTransactions);
        return savedHistoriqueTransaction ;
    }

    /**Endpoint qui permet de récupérer l'historique des transactions**/
    public JSONArray getHistorique(int utilisateurId){
        return historiqueTransactionsRepository.getHistorique(utilisateurId);
    }
}
