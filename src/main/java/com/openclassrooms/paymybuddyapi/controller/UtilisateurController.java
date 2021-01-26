package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.repository.UtilisateurRepository;
import com.openclassrooms.paymybuddyapi.service.UtilisateurService;
import com.openclassrooms.paymybuddyapi.utils.CheckingDataBaseUtils;
import com.openclassrooms.paymybuddyapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private CheckingDataBaseUtils checkingDataBaseUtils ;
    @Autowired
    private PasswordUtils passwordUtils;

    /**Endpoint de /register
     * Create = @PostMapping("/register")
     * @param utilisateur
     * @return
     */
    @PostMapping("/register")
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur){
        if(checkingDataBaseUtils.utilisateurExist(utilisateur.getMail()) == true){
            return null ;
        }

        utilisateur.setPassword(passwordUtils.hashPassword(utilisateur.getPassword()));
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }
    @DeleteMapping("/utilisateur/{id}")
    public void deleteUser(@PathVariable("id") final Long id){
        utilisateurService.deleteUtilisateur(id);
    }
}
