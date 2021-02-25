package com.openclassrooms.paymybuddyapi.controller;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import com.openclassrooms.paymybuddyapi.service.PorteMonnaieService;
import com.openclassrooms.paymybuddyapi.service.UtilisateurService;
import com.openclassrooms.paymybuddyapi.utils.CheckingDataBaseUtils;
import com.openclassrooms.paymybuddyapi.utils.PasswordUtils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    @PostMapping("/utilisateur/register")
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur){
        utilisateur.setSoldesId(checkingDataBaseUtils.primaryKeyPorteMonnaie());
        utilisateur.setPassword(passwordUtils.hashPassword(utilisateur.getPassword()));
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    /** Endpoint de login?mail=<mail>&password=<password>**/
    @RequestMapping(value = "/utilisateur/login", method = RequestMethod.GET)
    public String loginUser(@RequestParam("mail") String mail, @RequestParam("password") String password){

        String hshPwd = passwordUtils.getPasswordFromDb(password,mail);
        return utilisateurService.loginUser(mail,hshPwd);
    }
    /**Cet endpoint permet de récupérer l'Id d'un utilisateur selon mail**/
    @RequestMapping(value = "/utilisateur", method = RequestMethod.GET)
    public String findIdByMail(@RequestParam("mail") String mail){
        return utilisateurService.findIdByMail(mail);
    }
    /**Endpoint qui permet de récuperer tout les utilisateurs de la base de données**/
    @GetMapping("/utilisateurs")
    public Iterable<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }
    /**Endpoint qui permet de récuperer un utilisateur de la base de données selon son ID**/
    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getUtilisataur(@PathVariable("id") final Long id){
        return utilisateurService.getUtilisateur(id);
    }
    /**Permet de récupérer l'ID en fonction du prénom**/
    @GetMapping(value = "/utilisateurIdByName")
    public String utilisateurIdByName(@RequestParam("firstName") String firstName){
        return utilisateurService.utilisateurIdByName(firstName);
    }
    /**Permet de récupérer le soldes ID en fonction de l'utilisateur de l'ID**/
    @GetMapping(value = "/utilisateur/soldesIdById")
    public String soldesIdByUserId(@RequestParam("utilisateurId") String utilisateurId){
        return utilisateurService.soldesIdByUserId(utilisateurId);
    }

    @GetMapping(value = "/utilisateur/firstNameById")
    public String firstNameByUserId(@RequestParam("utilisateurId") String utilisateurId){
        return utilisateurService.firstNameByUserId(utilisateurId);
    }
}
