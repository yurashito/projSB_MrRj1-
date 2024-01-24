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

import com.voiture.voiture.modele.BoiteDeVitesse;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin("http://localhost:8100")
@RequestMapping("/boiteDeVitesses")
public class BoiteDeVitesseController {
    private final BoiteDeVitesseService  BoiteDeVitesseService;

    @Autowired
    public BoiteDeVitesseController( BoiteDeVitesseService BoiteDeVitesseService){
        this.BoiteDeVitesseService= BoiteDeVitesseService;
    }

    @GetMapping
    public List<BoiteDeVitesse> selectAll() {
        return this.BoiteDeVitesseService.select();
    }

    @PostMapping("/create")
    public BoiteDeVitesse create(@RequestBody BoiteDeVitesse favorie){
        return BoiteDeVitesseService.CreerBoiteDeVitesse(favorie) ;
    }

    @PostMapping("/updateBoiteDeVitesse/{idBoiteDeVitesse}")
    public BoiteDeVitesse updateVoitureDefini(@PathVariable int idBoiteDeVitesse,@RequestBody BoiteDeVitesse modifier){
        return this.BoiteDeVitesseService.updateBoiteDeVitesse(idBoiteDeVitesse, modifier);
    }
    @PostMapping("/deleteBoiteDeVitesse/{idBoiteDeVitesse}")
    public void deleteLieu(@PathVariable int idLieu){
        this.BoiteDeVitesseService.deleteLieu(idLieu);

}
