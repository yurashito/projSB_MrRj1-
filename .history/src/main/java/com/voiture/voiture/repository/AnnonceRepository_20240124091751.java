package com.voiture.voiture.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.Utilisateur;

public interface AnnonceRepository extends JpaRepository<Annonce , Integer> {
    @Query(value = "select * from annonce where :idCreateur = idCreateur " , nativeQuery = true)
    List <AnnonceDetail> historiqueAnnonceUtilisateur(@Param("idCreateur") int idCreateur,int IdAnnonce,
    @RequestParam String Description,
    @RequestParam Timestamp  DateHeureAnnonce ,
    @RequestParam int IdVoiture,
    @RequestParam String Imatricule ,
    @RequestParam int  IdCouleur ,
    @RequestParam String  Couleur, 
    @RequestParam int  IdCreateur , 
    @RequestParam String NomCreateur ,
    @RequestParam int IdLieu ,
    @RequestParam String NomLieu,
    @RequestParam String Annee,
    @RequestParam double Prix ,
    @RequestParam double PourcentageAlaina,
    int EtatAnnonce) 
}