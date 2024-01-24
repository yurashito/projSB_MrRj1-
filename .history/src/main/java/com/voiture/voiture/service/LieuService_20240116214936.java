package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.voiture.voiture.repository.LieuRepository;
import com.voiture.voiture.modele.*;

@Service
public class LieuService {
    private final LieuRepository lieuRepository;

    @Autowired
    public LieuService(LieuRepository lieuRepository) {
        this.lieuRepository = lieuRepository;
    }

    public List<Lieu> select(){
        return this.lieuRepository.findAll();
    }

    public Lieu Creer(Lieu favorie){
        return lieuRepository.save(favorie);
    }

    public Lieu updateLieu(int idLieu,Lieu modifier){
        return this.lieuRepository.findById(idLieu).map(
            categorie ->{
                // categorie.setIdLieu(modifier.getIdLieu());
                categorie.setNomLieu(modifier.getNomLieu());
                categorie.setEtat(modifier.getEtat());
                return lieuRepository.save(categorie);
            }
        ).orElseThrow(() -> new RuntimeException("lieu pas trouver"));
    } 

    public Lieu deleteLieu(int idLieu) {
        return this.lieuRepository.findById(idLieu).map(
            lieu -> {
                lieu.setEtat(0); // Mettre l'état à 0 pour indiquer que l'entité est supprimée
                return lieuRepository.save(lieu);
            }
        ).orElseThrow(() -> new RuntimeException("Lieu non trouvé"));
    }
    
    @PostMapping("/deleteUtilisateur/{idUtilisateur}")
    public void deleteUtilisateur(@PathVariable int idUtilisateur){
        this.utilisateurService.delete(idUtilisateur);
    
}
