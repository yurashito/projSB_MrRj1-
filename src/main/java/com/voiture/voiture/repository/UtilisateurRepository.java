package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.Utilisateur;


public interface UtilisateurRepository extends   JpaRepository<Utilisateur , Integer>  {

    @Query(value = "select * from utilisateur where :mail = mail and :mdp =  mdp " , nativeQuery = true)
    Utilisateur verifierUtilisateur(@Param("mail") String nom , @Param("mdp") String mdp);
    
}
