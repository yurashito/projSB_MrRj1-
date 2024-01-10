package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Model;


public interface ModelRepository extends  JpaRepository<Model , Integer> {
    
}
