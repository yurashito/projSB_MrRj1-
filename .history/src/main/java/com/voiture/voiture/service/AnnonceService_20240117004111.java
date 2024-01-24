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

    public BoiteDeVitesse deleteAnnonce(int idBoiteDeVitesse){
        return this.boiteDeVitesseRepository.findById(idBoiteDeVitesse).map(
            boiteDeVitesse ->{
                // boiteDeVitesse.setIdBoiteDeVitesse(modifier.getIdBoiteDeVitesse());
                boiteDeVitesse.setEtat(0);
                return boiteDeVitesseRepository.save(boiteDeVitesse);
            }
        ).orElseThrow(() -> new RuntimeException("boite de vitesse pas trouver"));
    }
}