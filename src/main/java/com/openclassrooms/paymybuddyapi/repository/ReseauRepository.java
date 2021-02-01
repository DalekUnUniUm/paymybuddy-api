package com.openclassrooms.paymybuddyapi.repository;

import com.openclassrooms.paymybuddyapi.model.Reseau;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseauRepository extends CrudRepository<Reseau,Long> {

    /**Renvoie le nombre d'ami de l'utilisateur selon l'ID de l'utilisateur**/
    @Query(value = "SELECT COUNT(*) FROM reseau r WHERE r.userA_id = :userAId OR r.userB_id = :userBId", nativeQuery = true)
    int numberOfFriends(@Param("userAId") int userIdA, @Param("userBId") int userIdB);

    /**Renvoie si deux personnes sont déjà amis**/
    @Query(value = "SELECT COUNT(*) FROM reseau r WHERE r.userA_id = :userAId AND r.userB_id = :userBId", nativeQuery = true)
    int isFriends(@Param("userAId") int userIdA, @Param("userBId") int userIdB);

}
