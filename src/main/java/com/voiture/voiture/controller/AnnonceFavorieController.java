package com.voiture.voiture.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.AnnonceFavorie;

@RestController
@RequestMapping("/listeAnnonceFavorie")  
public class AnnonceFavorieController {
//    private final AnnonceFavorie annonceFavories;

//    @Autowired
//    public AnnonceFavorieController(AnnonceFavorie annonceFavorie){
//     this.annonceFavories=annonceFavorie;
//    }

   @GetMapping("/selectAll")
   public List<AnnonceFavorie> selectAll() throws Exception{
      Connexion co = new Connexion();
      Connection connection = co.getConnex();
      AnnonceFavorie annonceFavorie = new AnnonceFavorie();
      List<AnnonceFavorie> favories = annonceFavorie.Favorie(connection);
      connection.close();
        return favories;
   }

}
