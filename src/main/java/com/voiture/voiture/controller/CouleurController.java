package com.voiture.voiture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.voiture.voiture.modele.*;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin
@RequestMapping("/couleurs")
public class CouleurController {
    private final CouleurService  CouleurService;

    @Autowired
    public CouleurController( CouleurService CouleurService){
        this.CouleurService= CouleurService;
    }

    @GetMapping
    public List<Couleur> selectAll() {
        return this.CouleurService.select();
    }

    @PostMapping("/create")
    public Couleur create(@RequestBody Couleur favorie){
        return CouleurService.Creer(favorie) ;
        
    }

}
