package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voiture.voiture.modele.Favorie;

public interface FavorieRepository extends JpaRepository<Favorie,Integer>{
    
}
