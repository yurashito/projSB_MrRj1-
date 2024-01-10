package com.voiture.voiture.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.Favorie;
import com.voiture.voiture.service.FavorieService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/favorie")
@AllArgsConstructor
public class FavorieController {
    private final FavorieService favorieService;

    @PostMapping("/create")
    public Favorie create(@RequestBody Favorie favorie){
        return favorieService.CreerFavorie(favorie) ;
    }
}
