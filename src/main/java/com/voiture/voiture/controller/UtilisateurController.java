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
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService UtilisateurService;
    private final JwtTokenUtil JwtTokenUtil;

    @Autowired
    public UtilisateurController( UtilisateurService UtilisateurService ,JwtTokenUtil JwtTokenUtil ){
        this.UtilisateurService= UtilisateurService;
        this.JwtTokenUtil = JwtTokenUtil;
    }

    @GetMapping
    public List<Utilisateur> selectAll() {
        return this.UtilisateurService.select();
    }

    @PostMapping("/create")
    public Utilisateur create(@RequestBody Utilisateur favorie){
        return UtilisateurService.Creer(favorie) ;
    }

     @PostMapping("/updateUtilisateur/{idUtilisateur}")
    public Utilisateur updateUtilisateur(@PathVariable int idUtilisateur,@RequestBody Utilisateur modifier){
        return this.UtilisateurService.update(idUtilisateur, modifier);
    }

    
    @PostMapping("/verifierUser")
    public ResponseEntity<Object> obtenirUtilisateursParNomEtMotDePasse(@RequestBody Utilisateur utilisateur) {
         
         boolean conditionErreur = UtilisateurService.verifUtilisateur(utilisateur.getNomUtilisateur(),utilisateur.getMdp() );;

         if (conditionErreur==false) {
             // Renvoyer une réponse d'erreur avec un objet JSON détaillé directement
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                 Map.of(
                     "status", HttpStatus.BAD_REQUEST.value(),
                     "message", "Une erreur s'est produite : token non trouver",
                     "timestamp", System.currentTimeMillis()
                 )
             );
         } else {
             String token = JwtTokenUtil.generateToken(utilisateur);
             return ResponseEntity.ok(token);
         }

    }
}