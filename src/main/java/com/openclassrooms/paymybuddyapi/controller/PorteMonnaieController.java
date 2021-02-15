package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.service.PorteMonnaieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PorteMonnaieController {

    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    /**Endpoint qui permet la création d'un porte monnaie lors de l'enregistrement d'une personne**/
    @PostMapping("/wallet")
    public PorteMonnaie createPorteMonnaie(@RequestBody PorteMonnaie porteMonnaie){
        return porteMonnaieService.savePorteMonnaie(porteMonnaie);
    }

    /**Endpoint qui permet de récupérer le soldes selon l'ID de soldes_id dans la table utilisateur**/
    @GetMapping("/wallet/soldes")
    public int getSoldes(@RequestParam("soldesId") int soldesId){
        return porteMonnaieService.getSoldes(soldesId);
    }

    /**Endpoint qui permet de d'ajouter de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @PutMapping("/wallet/updateSoldesAdd")
    public void updateSoldesAdd(@RequestParam("addSoldes") int addSoldes, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateSoldesAdd(addSoldes,porteMonnaieId);
    }

    /**Endpoint qui permet de d'enelver de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @PutMapping("/wallet/updateSoldesSoustract")
    public void updateSoldesSoustract(@RequestParam("soustractSoldes") int soustractSoldes, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateSoldesSoustract(soustractSoldes,porteMonnaieId);
    }
}
