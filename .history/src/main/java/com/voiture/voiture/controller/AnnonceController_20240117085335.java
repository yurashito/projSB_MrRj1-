package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService  annonceService;

    @Autowired
    public AnnonceController( AnnonceService annonceService){
        this.annonceService= annonceService;
    }

    @PostMapping("/create")
    public Annonce create(@RequestBody Annonce annonce){
        return annonceService.Creer(annonce) ;
    }
    
    
    @PostMapping("/deleteBoiteDeVitesse/{idBoiteDeVitesse}")
    public void deleteLieu(@PathVariable int idBoiteDeVitesse){
        this.BoiteDeVitesseService.deleteBoiteDeVitesse(idBoiteDeVitesse);
    }
    
}
