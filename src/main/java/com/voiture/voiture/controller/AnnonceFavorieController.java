package com.voiture.voiture.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.AnnonceFavorie;

@RestController
@RequestMapping("/listeAnnonceFavorie")  
public class AnnonceFavorieController {
   
   @GetMapping("/selectFavorie/{idUtilisateur}")
   public AnnonceFavorie selectAllByCreateur(@PathVariable int idUtilisateur) throws Exception{
      Connexion co = new Connexion();
      Connection connection = co.getConnex();
      AnnonceFavorie annonceFavorie = new AnnonceFavorie();
      AnnonceFavorie annonce = annonceFavorie.AnnonceFavorie(connection,idUtilisateur);
      connection.close();
        return annonce;
   }

}
