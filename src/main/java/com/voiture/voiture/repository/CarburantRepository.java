package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Carburant;

public interface CarburantRepository  extends JpaRepository<Carburant , Integer>  {
    
}
