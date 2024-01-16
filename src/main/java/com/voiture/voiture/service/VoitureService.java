package com.voiture.voiture.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.voiture.voiture.modele.Voiture;
import com.voiture.voiture.repository.VoitureRepostory;

@Service
public class VoitureService {
  private final VoitureRepostory voitureRepostory;
  
  @Autowired
  public VoitureService (VoitureRepostory voitureRepostory){

    this.voitureRepostory = voitureRepostory;
  }

  public List<Voiture> select(){
    return this.voitureRepostory.findAll();
  }

  public Voiture CreerVoiture (Voiture voiture){

    return voitureRepostory.save(voiture);
  }

  public Voiture updateVoiture (int idVoiture,Voiture modifier){
        return this.voitureRepostory.findById(idVoiture).map(
            voiture ->{
                
                voiture.setIdVoiture(modifier.getIdVoiture());
                voiture.setIdMatricule(modifier.getIdMatricule());
                voiture.setIdCategorie(modifier.getIdCategorie());
                voiture.setIdMarque(modifier.getIdMarque());
                voiture.setIdCarburant(modifier.getIdCarburant());
                voiture.setIdModel(modifier.getIdModel());
                voiture.setIdBoiteDeVitesse(modifier.getIdBoiteDeVitesse());
                voiture.setIdCouleur(modifier.getIdCouleur());
                return voitureRepostory.save(voiture);
            }
        ).orElseThrow(() -> new RuntimeException("voiture pas trouver"));
    }

}
