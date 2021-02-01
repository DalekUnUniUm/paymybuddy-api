package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import com.openclassrooms.paymybuddyapi.repository.HistoriqueTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriqueTransactionsService {

    @Autowired
    private HistoriqueTransactionsRepository historiqueTransactionsRepository ;

    public HistoriqueTransactions saveHistorique(HistoriqueTransactions historiqueTransactions){
        HistoriqueTransactions savedHistoriqueTransaction = historiqueTransactionsRepository.save(historiqueTransactions);
        return savedHistoriqueTransaction ;
    }
}
