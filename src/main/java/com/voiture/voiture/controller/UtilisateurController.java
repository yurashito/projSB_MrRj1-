package com.voiture.voiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.service.*;
import com.voiture.voiture.modele.*;

@RestController
@CrossOrigin
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService UtilisateurService;

    @Autowired
    public UtilisateurController( UtilisateurService UtilisateurService){
        this.UtilisateurService= UtilisateurService;
    }

    @GetMapping
    public List<Utilisateur> selectAll() {
        return this.UtilisateurService.select();
    }

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur favorie){
        return UtilisateurService.Creer(favorie) ;
    }

     @PostMapping("/updateUtilisateur/{idUtilisateur}")
    public Utilisateur updateUtilisateur(@PathVariable int idUtilisateur,@RequestBody Utilisateur modifier){
        return this.UtilisateurService.update(idUtilisateur, modifier);
    }
}
