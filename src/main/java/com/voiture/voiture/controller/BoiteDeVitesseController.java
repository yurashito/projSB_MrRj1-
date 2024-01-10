package com.voiture.voiture.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.BoiteDeVitesse;
import com.voiture.voiture.service.*;

@RestController
@RequestMapping("/boiteDeVitesse")
public class BoiteDeVitesseController {
    private final BoiteDeVitesseService  BoiteDeVitesseService;

    @Autowired
    public BoiteDeVitesseController( BoiteDeVitesseService BoiteDeVitesseService){
        this.BoiteDeVitesseService= BoiteDeVitesseService;
    }

    @GetMapping("/boiteDeVitesses")
    public List<BoiteDeVitesse> selectAll() {
        return this.BoiteDeVitesseService.select();
    }

    @PostMapping("/create")
    public BoiteDeVitesse create(@RequestBody BoiteDeVitesse favorie){
        return BoiteDeVitesseService.CreerBoiteDeVitesse(favorie) ;
    }

}
