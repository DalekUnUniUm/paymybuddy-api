package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.PorteMonnaie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PorteMonnaieRepository extends CrudRepository<PorteMonnaie, Long> {

    @Query(value = "SELECT porte_monnaie_id FROM porte_monnaie WHERE available = :available LIMIT 1", nativeQuery = true)
    int findIdByAvailable(@Param("available") boolean available);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE porte_monnaie p SET p.available = false WHERE p.porte_monnaie_id = :porte_monnaie_id ", nativeQuery = true)
    void updateAvailablePorteMonnaie(@Param("porte_monnaie_id") int porteMonnaieId);

    /**Permet de récupérer le soldes selon l'ID de soldes_id dans la table utilisateur**/
    @Query(value = "SELECT soldes FROM porte_monnaie p WHERE p.porte_monnaie_id = :soldesId", nativeQuery = true)
    int getSoldes(@Param("soldesId") int soldesId);

    /**Endpoint qui permet de d'ajouter de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE porte_monnaie p SET p.soldes = p.soldes + :addSoldes WHERE p.porte_monnaie_id = :porte_monnaie_id", nativeQuery = true)
    void updateSoldesAdd(@Param("addSoldes") int addSoldes, @Param("porte_monnaie_id") int porteMonnaieId);

    /**Endpoint qui permet de d'enlever de l'argent selon l'ID de soldes_id dans la table utilisateur**/
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "UPDATE porte_monnaie p SET p.soldes = p.soldes - :soustractSoldes WHERE p.porte_monnaie_id = :porte_monnaie_id", nativeQuery = true)
    void updateSoldesSoustract(@Param("soustractSoldes") int soustractSoldes, @Param("porte_monnaie_id") int porteMonnaieId);
}
