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
@RequestMapping("/marques")
public class MarqueController {
    private final MarqueService marqueService;

    @Autowired
    public MarqueController( MarqueService marqueService){
        this.marqueService= marqueService;
    }

    @GetMapping
    public List<Marque> selectAll() {
        return this.marqueService.select();
    }

    @PostMapping("/create")
    public Marque create(@RequestBody Marque favorie){
        return marqueService.Creer(favorie) ;
    }

     @PostMapping("/updateMarque/{idMarque}")
    public Marque updateVoitureDefini(@PathVariable int idMarque,@RequestBody Marque modifier){
        return this.marqueService.update(idMarque, modifier);
    }
    @PostMapping("/deleteMarque/{idMarque}")
    public void deleteMarque(@PathVariable int idMarque){
         this.marqueService.deleteMarque(idMarque);
    }
    
}
