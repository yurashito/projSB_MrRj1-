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
}
