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
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceParUtilisateur;
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

    @GetMapping
    public List<Annonce> selectAll() {
        return this.annonceService.select();
    }

    @PostMapping("/create")
    public Annonce create(@RequestBody Annonce annonce){
        return annonceService.Creer(annonce) ;
    }

    @PostMapping("/validerAnnonce/{idAnnonce}")
    public Annonce ValiderAnnonce(@PathVariable int idAnnonce){
        return this.annonceService.ValidatioAnnonce(idAnnonce);
    }

    @GetMapping("/annonceUtilisateur/{idUtilisateur}")
   public AnnonceParUtilisateur selectByUser(@PathVariable int idUtilisateur)throws Exception{
        Connexion co = new Connexion();
        Connection connection = co.getConnex();
        Annonce annonce = new Annonce();
        AnnonceParUtilisateur a = annonce.get_annonce_by_utilisateur(connection,idUtilisateur );
        connection.close();
        return a;
   }
    
}
