package com.voiture.voiture.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.ListeAnnonce;
import com.voiture.voiture.repository.AnnonceDetailRepository;
import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.service.*;


@RestController
@CrossOrigin
@RequestMapping("/validationAnnonce")
public class ValidationController {
    private final AnnonceService annonceService;

    @Autowired
    public ValidationController( AnnonceService annonceService){
        this.annonceService= annonceService;
    }

    @PostMapping("/validerAnnonce/{idAnnonce}")
    public Annonce ValiderAnnonce(@PathVariable int idAnnonce){
        return this.annonceService.ValidatioAnnonce(idAnnonce);
    }
    
}
