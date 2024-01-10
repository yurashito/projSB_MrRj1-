package com.voiture.voiture.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Marque;
import com.voiture.voiture.modele.Model;

public interface MarqueRepository extends  JpaRepository<Marque , Integer> {

    static Model save(Model favorie) {
        return null;
    }
    
}
