package com.voiture.voiture.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.service.*;
import com.voiture.voiture.modele.*;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    private final CategorieService CategorieService;

    @Autowired
    public CategorieController( CategorieService CategorieService){
        this.CategorieService= CategorieService;
    }

    @GetMapping("/categories")
    public List<Categorie> selectAll() {
        return this.CategorieService.select();
    }

    @PostMapping("/create")
    public Categorie create(@RequestBody Categorie favorie){
        return CategorieService.Creer(favorie) ;
    }
}
