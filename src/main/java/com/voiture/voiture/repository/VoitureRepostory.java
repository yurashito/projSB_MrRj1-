package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Voiture;


public interface VoitureRepostory extends JpaRepository<Voiture , Integer>{
    
}
