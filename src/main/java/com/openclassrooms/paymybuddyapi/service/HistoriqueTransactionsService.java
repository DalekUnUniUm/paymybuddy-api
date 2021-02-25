package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.repository.HistoriqueTransactionsRepository;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueTransactionsService {

    @Autowired
    private HistoriqueTransactionsRepository historiqueTransactionsRepository ;

    public HistoriqueTransactions saveHistorique(HistoriqueTransactions historiqueTransactions){
        HistoriqueTransactions savedHistoriqueTransaction = historiqueTransactionsRepository.save(historiqueTransactions);
        return savedHistoriqueTransaction ;
    }

    /**Endpoint qui permet de récupérer l'historique des transactions**/
    public JSONArray getHistoriqueId(int utilisateurId){
        return historiqueTransactionsRepository.getHistoriqueId(utilisateurId);
    }
    public Iterable<HistoriqueTransactions> getHistoriqueById(List<Long> ids){
        return historiqueTransactionsRepository.findAllById(ids);
    }

}
