package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voiture.voiture.modele.BoiteDeVitesse;

public interface BoiteDeVitesseRepository extends JpaRepository<BoiteDeVitesse , Integer>{
    
}
