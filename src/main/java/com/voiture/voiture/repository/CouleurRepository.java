package com.voiture.voiture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.*;

@Repository
public interface CouleurRepository extends JpaRepository<Couleur , Integer> {
    
}
