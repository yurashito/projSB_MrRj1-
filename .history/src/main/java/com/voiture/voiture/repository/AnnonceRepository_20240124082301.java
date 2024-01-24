package com.voiture.voiture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.Utilisateur;

public interface AnnonceRepository extends JpaRepository<Annonce , Integer> {
    @Query(value = "select * from annonce where :idCreateur = idCreateur " , nativeQuery = true)
        List <AnnonceDetail> historiqueAnnonceUtilisateur(@Param("idCreateur") int idCreateur); 
}