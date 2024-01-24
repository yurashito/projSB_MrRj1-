package com.voiture.voiture.service;


import com.voiture.voiture.modele.Favorie;
import java.util.*;
public interface FavorieService {
    Favorie CreerFavorie(Favorie favorie);
    List<Favorie> select();
    Favorie deleteFavorie(int idFavorie);
    Favorie 
}