package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.Utilisateur;

public interface AnnonceRepository extends JpaRepository<Annonce , Integer> {
     @Query(value = "select * from annonce where :idcreateur = idannonce and :mdp =  mdp " , nativeQuery = true)
    Utilisateur verifierUtilisateur(@Param("id") String nom , @Param("mdp") String mdp);
}