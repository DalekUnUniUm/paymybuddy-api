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
    @PutMapping("/wallet/bankaccount")
    public void updateBankAccount(@RequestParam("bankaccount") String bankAccount, @RequestParam("soldesId") int porteMonnaieId){
        porteMonnaieService.updateBankAccount(bankAccount,porteMonnaieId);
    }
    /**Permet de récupérer le numéro du compte en banque**/
    @GetMapping("/wallet/getBankAccount")
    public String getBankAccount(@RequestParam("soldesId") int porteMonnaieId){
        return porteMonnaieService.getBankAccount(porteMonnaieId);
    }
    /**Endpoint qui permet de récupérer le soldes selon l'ID de soldes_id dans la table utilisateur**/
    @GetMapping("/wallet/soldes")
    public double getSoldes(@RequestParam("soldesId") int soldesId){
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
