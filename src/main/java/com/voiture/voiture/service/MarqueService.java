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

}
