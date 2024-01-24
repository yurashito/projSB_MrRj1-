package com.voiture.voiture.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.AnnonceParUtilisateur;
import com.voiture.voiture.modele.ListeAnnonce;
import com.voiture.voiture.repository.AnnonceDetailRepository;
import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.service.*;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService  annonceService;
    private final AnnonceDetailRepository annonceDetailRepository;
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceController( AnnonceService annonceService , AnnonceDetailRepository annonceDetailRepository,AnnonceRepository annonceRepository){
        this.annonceService= annonceService;
        this.annonceDetailRepository= annonceDetailRepository;
        this.annonceRepository= annonceRepository;
    }
    @GetMapping
    public List<Annonce> selectAll() {
        return this.annonceService.select();
    }

    @PostMapping("/create")
    public Annonce create(@RequestBody Annonce annonce){
        return annonceService.Creer(annonce) ;
    }
    @PostMapping("/deleteAnnonce/{idannonce}")
    public void deleteAnnonce(@PathVariable int idannonce){
        this.annonceService.deleteAnnonce(idannonce);
    }

    @PostMapping("/validerAnnonce/{idAnnonce}")
    public Annonce ValiderAnnonce(@PathVariable int idAnnonce){
        return this.annonceService.ValidatioAnnonce(idAnnonce);
    }

    @GetMapping("/annonceUtilisateur/{idUtilisateur}")
   public AnnonceParUtilisateur selectByUser(@PathVariable int idUtilisateur)throws Exception{
        Connexion co = new Connexion();
        Connection connection = co.getConnex();
        Annonce annonce = new Annonce();
        AnnonceParUtilisateur a = annonce.get_annonce_by_utilisateur(connection,idUtilisateur );
        connection.close();
        return a;
   }

   @GetMapping("/listesAnnnonces")
    public List<ListeAnnonce> listeAnnonce ()throws Exception{
        Connexion co = new Connexion();
        Connection connection = co.getConnex();
        Annonce a = new Annonce();
        List<ListeAnnonce> liste = a.listeAnnonce(connection);
        connection.close();
        return liste;

    }    
   @GetMapping("/recherche")
    public List<AnnonceDetail> rechercheAnnonce(@RequestParam String prixMin , @RequestParam String prixMax ,@RequestParam String idBoitedevitesse , @RequestParam String idCarburant , @RequestParam String idCategorie , @RequestParam String idLieu , @RequestParam String idMarque  , @RequestParam String idModel  ){
        return annonceDetailRepository.rechercheAnnonce(prixMin ,   prixMax ,  idBoitedevitesse ,  idCarburant ,   idCategorie ,   idLieu ,   idMarque  ,   idModel);
    } 

    @GetMapping("/historiqueAnnonce")
    public List<AnnonceDetail> historiqueAnnonceUtilisateur(@RequestParam int IdAnnonce,
    @RequestParam String Description,
    @RequestParam Timestamp  DateHeureAnnonce ,
    @RequestParam int IdVoiture,
    @RequestParam String Imatricule ,
    @RequestParam int  IdCouleur ,
    @RequestParam String  Couleur, 
    @RequestParam int  IdCreateur , 
    @RequestParam String NomCreateur ,
    @RequestParam int IdLieu ,
    @RequestParam String NomLieu,
    @RequestParam String Annee,
    @RequestParam double Prix ,
    @RequestParam double PourcentageAlaina,
    int EtatAnnonce) {
        return annonceRepository.historiqueAnnonceUtilisateur(IdAnnonce,
         Description,
         DateHeureAnnonce ,
         IdVoiture,
        Imatricule ,
        IdCouleur ,
        @RequestParam String  Couleur, 
        @RequestParam int  IdCreateur , 
        @RequestParam String NomCreateur ,
        @RequestParam int IdLieu ,
        @RequestParam String NomLieu,
         Annee,
        Prix ,
      PourcentageAlaina,);
    }
    
}
