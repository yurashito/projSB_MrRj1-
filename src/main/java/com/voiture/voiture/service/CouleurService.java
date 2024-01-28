package com.voiture.voiture.service;


import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.repository.CouleurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.voiture.voiture.modele.*;
@Service
public class CouleurService {
    private final com.voiture.voiture.repository.CouleurRepository CouleurRepository;

    @Autowired
    public CouleurService(CouleurRepository CouleurRepository) {
        this.CouleurRepository = CouleurRepository;
    }

    public List<Couleur> select(){
        return this.CouleurRepository.findAll();
    }

    public Couleur Creer(Couleur Couleur){
        return CouleurRepository.save(Couleur);
    }

}
