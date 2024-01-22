package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Utilisateur;


public interface UtilisateurRepository extends   JpaRepository<Utilisateur , Integer>  {

    @Query(value = "select * from utilisateur where :nom = nomUtilisateur and :mdp =  mdp " , nativeQuery = true)
    Utilisateur verifierUtilisateur(@Param("nom") String nom , @Param("mdp") String mdp);
    
}
