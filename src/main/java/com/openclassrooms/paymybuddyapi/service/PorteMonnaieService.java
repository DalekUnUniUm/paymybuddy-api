package com.openclassrooms.paymybuddyapi.service;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import com.openclassrooms.paymybuddyapi.repository.PorteMonnaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PorteMonnaieService {

    @Autowired
    private PorteMonnaieRepository porteMonnaieRepository ;

    public PorteMonnaie savePorteMonnaie(PorteMonnaie porteMonnaie){
        PorteMonnaie savedPorteMonnaie = porteMonnaieRepository.save(porteMonnaie);
        return savedPorteMonnaie ;
    }

    /**Endpoint qui permet de récupérer le solde selon l'ID de soldes_id dans la table utilisateur**/
    public int getSoldes(int soldesID){
        return porteMonnaieRepository.getSoldes(soldesID);
    }

    /**Endpoint qui permet de d'ajouter de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @Transactional
    public void updateSoldesAdd(int addSoldes, int porteMonnaieId){
        porteMonnaieRepository.updateSoldesAdd(addSoldes, porteMonnaieId);
    }
    @Transactional
    public void updateSoldesSoustract(int soustractSoldes, int porteMonnaieId){
        porteMonnaieRepository.updateSoldesSoustract(soustractSoldes, porteMonnaieId);
    }
}
