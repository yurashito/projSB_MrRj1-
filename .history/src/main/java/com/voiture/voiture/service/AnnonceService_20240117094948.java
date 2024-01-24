package com.voiture.voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.modele.*;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce Creer(Annonce annonce){
        return annonceRepository.save(annonce);
    }

    public Annonce deleteAnnonce(int idnnonce){
        return this.annonceRepository.findById(Annonce).map (
            annonce ->{
                annonce.setEtatAnnonce(1);
                return annonceRepository.save(annonce);
            }
        ).orElseThrow(() -> new RuntimeException(" Annonce  pas trouver"));
    }
}