package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.*;
import com.voiture.voiture.modele.*;

@Service
public class MarqueService {
    private final MarqueRepository MarqueRepository;

    @Autowired
    public MarqueService(MarqueRepository MarqueRepository) {
        this.MarqueRepository = MarqueRepository;
    }

    public List<Marque> select(){
        return this.MarqueRepository.findAll();
    }

    public Marque Creer(Marque favorie){
        return MarqueRepository.save(favorie);
    }

    public Marque update(int idMarque,Marque modifier){
        return this.MarqueRepository.findById(idMarque).map(
            marque ->{
                // marque.setIdMarque(modifier.getIdMarque());
                marque.setNomMarque(modifier.getNomMarque());
                marque.setEtat(modifier.getEtat());
                return MarqueRepository.save(marque);
            }
        ).orElseThrow(() -> new RuntimeException("marque pas trouver"));
    }
    public Marque deleteMarque(int idMarque){
        return this.MarqueRepository.findById(idMarque).map(
            marque ->{
                marque.setEtat(0);
                return MarqueRepository.save(marque);
            }
        ).orElseThrow(() -> new RuntimeException("marque pas trouver"));
    }

}
