package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueTransactionsRepository extends CrudRepository<HistoriqueTransactions, Long> {
}
