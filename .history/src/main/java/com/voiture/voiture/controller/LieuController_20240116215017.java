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
@CrossOrigin("http://localhost:8100")
@RequestMapping("/lieux")
public class LieuController {
    private final LieuService LieuService;

    @Autowired
    public LieuController( LieuService LieuService){
        this.LieuService= LieuService;
    }

    @GetMapping
    public List<Lieu> selectAll() {
        return this.LieuService.select();
    }

    @PostMapping("/create")
    public Lieu create(@RequestBody Lieu favorie){
        return LieuService.Creer(favorie) ;
    }

    @PostMapping("/updateVoitureDefini/{idLieu}")
    public Lieu updateVoitureDefini(@PathVariable int idLieu,@RequestBody Lieu modifier){
        return this.LieuService.updateLieu(idLieu, modifier);
    }
    @PostMapping("/deleteLieu/{idUtilisateur}")
    public void deleteUtilisateur(@PathVariable int idUtilisateur){
        this.utilisateurService.delete(idUtilisateur);
    

}
