package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie , Integer> {
    
}
