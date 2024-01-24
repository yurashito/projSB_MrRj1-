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
@CrossOrigin("http://localhost:8100")
@RequestMapping("/carburants")
public class CarburantController {
    private final CarburantService CarburantService;

    @Autowired
    public CarburantController( CarburantService CarburantService){
        this.CarburantService= CarburantService;
    }

    @GetMapping
    public List<Carburant> selectAll() {
        return this.CarburantService.select();
    }

    @PostMapping("/create")
    public Carburant create(@RequestBody Carburant favorie){
        return CarburantService.Creer(favorie) ;
    }

     @PostMapping("/updateCarburant/{idCarburant}")
    public Carburant updateCarburant(@PathVariable int idCarburant,@RequestBody Carburant modifier){
        return this.CarburantService.update(idCarburant, modifier);
    }
    @PostMapping("/deleteCarburant/{idCarburant}")
    public void deleteLieu(@PathVariable int idLieu){
        this.CarburantService.deleteLieu(idLieu);
    }
}
