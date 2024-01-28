package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voiture.voiture.modele.Vente;

public interface VenteRepostory  extends JpaRepository<Vente , Integer>  {
    
}
