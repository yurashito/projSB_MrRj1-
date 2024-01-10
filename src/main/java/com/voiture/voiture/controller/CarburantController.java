package com.voiture.voiture.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.*;
import com.voiture.voiture.service.*;

@RestController
@RequestMapping("/carburant")
public class CarburantController {
    private final CarburantService CarburantService;

    @Autowired
    public CarburantController( CarburantService CarburantService){
        this.CarburantService= CarburantService;
    }

    @GetMapping("/carburants")
    public List<Carburant> selectAll() {
        return this.CarburantService.select();
    }

    @PostMapping("/create")
    public Carburant create(@RequestBody Carburant favorie){
        return CarburantService.Creer(favorie) ;
    }
}
