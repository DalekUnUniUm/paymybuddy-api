package com.openclassrooms.paymybuddyapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reseau")
public class Reseau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reseau_id ;

    @Column(name = "userA_id")
    private int userAId ;

    @Column(name = "userB_id")
    private int userBId ;


}
