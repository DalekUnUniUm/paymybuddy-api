package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    @Query(value = "SELECT * FROM utilisateurs u WHERE u.mail = :mail", nativeQuery = true)
    String findUserByMail(@Param("mail") String mail);
}
