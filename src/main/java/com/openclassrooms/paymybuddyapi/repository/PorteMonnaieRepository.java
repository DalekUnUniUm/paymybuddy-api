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
}
