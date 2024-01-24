package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Categorie;
import com.voiture.voiture.repository.CategorieRepository;


@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> select(){
        return this.categorieRepository.findAll();
    }

    public Categorie Creer(Categorie favorie){
        return categorieRepository.save(favorie);
    }

    public Categorie update(int idCategorie,Categorie modifier){
        return this.categorieRepository.findById(idCategorie).map(
            categorie ->{
                // categorie.setIdCategorie(modifier.getIdCategorie());
                categorie.setNomCategorie(modifier.getNomCategorie());
                categorie.setEtat(modifier.getEtat());
                return categorieRepository.save(categorie);
            }
        ).orElseThrow(() -> new RuntimeException("categorie pas trouver"));
    }
    public Categorie update(int idCategorie,Categorie modifier){
        return this.categorieRepository.findById(idCategorie).map(
            categorie ->{
                // categorie.setIdCategorie(modifier.getIdCategorie());
                categorie.setNomCategorie(modifier.getNomCategorie());
                categorie.setEtat(modifier.getEtat());
                return categorieRepository.save(categorie);
            }
        ).orElseThrow(() -> new RuntimeException("categorie pas trouver"));
    }
}
