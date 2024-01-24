package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.Utilisateur;

public interface AnnonceRepository extends JpaRepository<  Integer> {
    @Query(value = "select * from annonce where :idCreateur = idCreateur " , nativeQuery = true)
    Utilisateur historiqueAnnonceUtilisateur(@Param("idCreateur") int idCreateur);
}