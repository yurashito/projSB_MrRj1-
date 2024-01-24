package com.voiture.voiture.service;

import java.util.List;

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

    public List<Annonce> select(){
        return this.annonceRepository.findAll();
    }

    public Annonce Creer(Annonce annonce){
        return annonceRepository.save(annonce);
    }
    public Annonce deleteAnnonce(int idannonce){
        return this.annonceRepository.findById(idannonce).map (
            annonce ->{
                annonce.setEtatAnnonce(1);
                return annonceRepository.save(annonce);
            }
        ).orElseThrow(() -> new RuntimeException(" Annonce  pas trouver"));
    }

    public Annonce ValidatioAnnonce(int idAnnonce){
        return this.annonceRepository.findById(idAnnonce).map(
            annonce ->{
                annonce.setEtatAnnonce(1);
                return annonceRepository.save(annonce);
            }
        ).orElseThrow(() -> new RuntimeException("Annonce innexistante"));
    } 
    public Annonce historiqueAnnonce(int idAnnonce, Utilisateur idUtilisateur) {
        return this.annonceRepository.findById(idAnnonce).map(
            annonce -> {
                List<Annonce> annoncesUtilisateur = annonceRepository.findByUtilisateurId(idUtilisateur.getId());
                return annonceRepository.save(annonce);
                return annonce;
            }
        ).orElseThrow(() -> new RuntimeException("historique Annonce"));
    }
    
}