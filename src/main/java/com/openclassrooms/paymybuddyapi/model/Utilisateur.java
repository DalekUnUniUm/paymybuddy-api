package com.openclassrooms.paymybuddyapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateur_id ;

    private String mail ;
    private String password ;
    @Column(name = "nom")
    private String lastName ;
    @Column(name = "prenom")
    private String firstName ;
    @Column(name = "soldes_id")
    private int soldesId ;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
