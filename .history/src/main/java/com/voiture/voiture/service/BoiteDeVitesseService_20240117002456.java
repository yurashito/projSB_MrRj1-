package com.voiture.voiture.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.BoiteDeVitesseRepository;
import com.voiture.voiture.modele.*;


@Service
public class BoiteDeVitesseService {
    private final BoiteDeVitesseRepository boiteDeVitesseRepository;

    @Autowired
    public BoiteDeVitesseService(BoiteDeVitesseRepository boiteDeVitesseRepository) {
        this.boiteDeVitesseRepository = boiteDeVitesseRepository;
    }

    public List<BoiteDeVitesse> select(){
        return this.boiteDeVitesseRepository.findAll();
    }

    public BoiteDeVitesse CreerBoiteDeVitesse(BoiteDeVitesse favorie){
        return boiteDeVitesseRepository.save(favorie);
    }

    public BoiteDeVitesse updateBoiteDeVitesse(int idBoiteDeVitesse,BoiteDeVitesse modifier){
        return this.boiteDeVitesseRepository.findById(idBoiteDeVitesse).map(
            boiteDeVitesse ->{
                // boiteDeVitesse.setIdBoiteDeVitesse(modifier.getIdBoiteDeVitesse());
                boiteDeVitesse.setNomBoiteDeVitesse(modifier.getNomBoiteDeVitesse());
                boiteDeVitesse.setEtat(modifier.getEtat());
                return boiteDeVitesseRepository.save(boiteDeVitesse);
            }
        ).orElseThrow(() -> new RuntimeException("boite de vitesse pas trouver"));
    }
    public BoiteDeVitesse deleteBoiteDeVitesse(int idBoiteDeVitesse){
        return this.boiteDeVitesseRepository.findById(idBoiteDeVitesse).map(
            boiteDeVitesse ->{
                // boiteDeVitesse.setIdBoiteDeVitesse(modifier.getIdBoiteDeVitesse());
                boiteDeVitesse.setEtat(0);
                return boiteDeVitesseRepository.save(boiteDeVitesse);
            }
        ).orElseThrow(() -> new RuntimeException("boite de vitesse pas trouver"));
    }
   
}
