package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Lieu;

public interface LieuRepository   extends JpaRepository<Lieu , Integer>{

    
}
