package com.openclassrooms.paymybuddyapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "historique_transaction")
public class HistoriqueTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hisotirqueTransactionsId ;

    @Column(name = "utilisateur_id")
    private int utilisateurId ;

    @Column(name = "userAorB")
    private int userAOrBId ;

    @Column(name = "description")
    private String description;

    @Column(name = "sommes")
    private int sommes ;

}
