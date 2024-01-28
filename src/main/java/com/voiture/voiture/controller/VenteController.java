package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

import com.voiture.voiture.modele.Carburant;
import com.voiture.voiture.service.CarburantService;
import com.voiture.voiture.service.VenteService;

@RestController
@CrossOrigin

@RequestMapping("/ventes")

public class VenteController {
  

    private final VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping("/nombreVentesDansMois")
    public long getNombreVentesDansMois(
            @RequestParam(name = "debutMois") Date debutMois,
            @RequestParam(name = "finMois") Date finMois) {
        return venteService.getNombreVentesDansMois(debutMois, finMois);
    }
}
