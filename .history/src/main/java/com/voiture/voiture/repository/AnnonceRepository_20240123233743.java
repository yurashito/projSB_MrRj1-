package com.voiture.voiture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voiture.voiture.modele.Annonce;
import java.util.*;

public interface AnnonceRepository extends JpaRepository<Annonce, inte> {
    List<Annonce> findByUtilisateurId(Long utilisateurId);
}