package com.voiture.voiture.service;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Favorie;
import com.voiture.voiture.repository.FavorieRepository;

import lombok.AllArgsConstructor;
import java.util.*;
@Service
@AllArgsConstructor
public class FavorieServiceImplement implements FavorieService  {
    private final FavorieRepository favorieRepository;
    
    @Override
    public Favorie CreerFavorie(Favorie favorie){
        return favorieRepository.save(favorie);
    }

    public List<Favorie> select(){
        return this.favorieRepository.findAll();
    }
}