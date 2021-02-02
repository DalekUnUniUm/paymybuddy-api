package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.HistoriqueTransactions;
import org.json.simple.JSONArray;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueTransactionsRepository extends CrudRepository<HistoriqueTransactions, Long> {

    /**Permet de récupérer l'historique des transactions**/
    @Query(value = "SELECT prenom, description, sommes FROM utilisateurs  INNER JOIN historique_transaction  WHERE utilisateurs.utilisateur_id = user_aorb AND historique_transaction.utilisateur_id = :utilisateur_id", nativeQuery = true)
    JSONArray getHistorique(@Param("utilisateur_id") int utilisateurId);
}
