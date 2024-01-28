package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.VenteParMois;
import com.voiture.voiture.service.VenteParMoisService;

import java.util.List;

@RestController
@RequestMapping("/vente-par-mois")
@CrossOrigin
public class VenteParMoisController {

    private final VenteParMoisService venteParMoisService;

    @Autowired
    public VenteParMoisController(VenteParMoisService venteParMoisService) {
        this.venteParMoisService = venteParMoisService;
    }

    @GetMapping
    public List<VenteParMois> getAllVentesParMois() {
        return venteParMoisService.getAllVentesParMois();
    }
}

