package com.voiture.voiture.service;


import com.voiture.voiture.modele.Categorie;
import com.voiture.voiture.modele.Favorie;
import java.util.*;
public interface FavorieService {
    Favorie CreerFavorie(Favorie favorie);
    List<Favorie> select();


    public Categorie deleteCategorie(int idCategorie){
        return this.categorieRepository.findById(idCategorie).map(
            categorie ->{
                categorie.setEtat(0);
                return categorieRepository.save(categorie);
            }
        ).orElseThrow(() -> new RuntimeException("categorie pas trouver"));
    }


}