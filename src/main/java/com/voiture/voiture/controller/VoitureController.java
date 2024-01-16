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

import com.voiture.voiture.modele.*;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin
@RequestMapping("/voitures")
public class VoitureController {
    private final VoitureService voitureService;
    
    @Autowired
    public VoitureController( VoitureService voitureService){
        this.voitureService= voitureService;
    }

    @PostMapping("/updateVoiture/{idVoiture}")
    public Voiture updateVoiture(@PathVariable int idVoiture,@RequestBody Voiture modifier){
        return this.voitureService.updateVoiture(idVoiture, modifier);
    }



    
}
