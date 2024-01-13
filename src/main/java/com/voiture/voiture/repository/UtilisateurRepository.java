package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Utilisateur;


public interface UtilisateurRepository extends   JpaRepository<Utilisateur , Integer>  {
    
}
