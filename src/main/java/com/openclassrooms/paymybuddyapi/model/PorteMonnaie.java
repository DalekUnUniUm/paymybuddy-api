package com.openclassrooms.paymybuddyapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "porte_monnaie")
public class PorteMonnaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long porteMonnaieId ;

    @Column(name = "soldes")
    private int soldes ;

    @Column(name = "available")
    private boolean available ;

    public int getSoldes() {
        return soldes;
    }

    public void setSoldes(int soldes) {
        this.soldes = soldes;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
