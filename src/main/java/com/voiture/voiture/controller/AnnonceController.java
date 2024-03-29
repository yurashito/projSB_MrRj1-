package com.voiture.voiture.controller;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.voiture.voiture.connex.Connexion;
import com.voiture.voiture.modele.Annonce;
import com.voiture.voiture.modele.AnnonceAvecPhoto;
import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.AnnonceParUtilisateur;
import com.voiture.voiture.modele.ListeAnnonce;
import com.voiture.voiture.repository.AnnonceDetailRepository;
import com.voiture.voiture.repository.AnnonceRepository;
import com.voiture.voiture.service.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@RestController
@CrossOrigin
@RequestMapping("/annonces")
public class AnnonceController {
    private final AnnonceService  annonceService;
    private final AnnonceDetailRepository annonceDetailRepository;
    private final AnnonceRepository annonceRepository;
    private final AnnonceDetailService annonceDetailService;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AnnonceController( AnnonceService annonceService , AnnonceDetailRepository annonceDetailRepository , AnnonceDetailService annonceDetailService , JwtTokenUtil jwtTokenUtil , AnnonceRepository annonceRepository){
        this.annonceService= annonceService;
        this.annonceDetailRepository= annonceDetailRepository;
        this.annonceDetailService= annonceDetailService;
        this.jwtTokenUtil= jwtTokenUtil;
        this.annonceRepository= annonceRepository;
    }
    @GetMapping
    public List<Annonce> selectAll() {
        return this.annonceService.select();
    }

    // @PostMapping("/create")
    // public Annonce create(@RequestBody Annonce annonce){
    //     return annonceService.Creer(annonce) ;
    // }

    @PostMapping("/creerAnnonce")
    public ResponseEntity<Object> obtenirUtilisateursParNomEtMotDePasse(javax.servlet.http.HttpServletRequest request,@RequestPart("annonce") Annonce annonce , @RequestPart("files") List<MultipartFile> listeFile) {    
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                try{
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        System.out.println("le idUtilisateur est : "+Integer.parseInt(claims.getBody().getSubject()));
                        String idUtilisateur = claims.getBody().getSubject();
                        annonce.setIdCreateur(Integer.parseInt(idUtilisateur));
                        annonceDetailService.insertionAnnonceAvecPhoto( annonce , listeFile);
                        return ResponseEntity.ok("l'annonce est belle et bien enregistre");
                    }else{
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                            Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Une erreur s'est produite : le token n'est plus valide",
                                "timestamp", System.currentTimeMillis()
                            )
                        );
                    } 
                }catch(Exception e){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        Map.of(
                            "status", HttpStatus.BAD_REQUEST.value(),
                            "message", e,
                            "timestamp", System.currentTimeMillis()
                        )
                    );
                }
            } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "message", "Une erreur s'est produite : le token n'est plus valide",
                    "timestamp", System.currentTimeMillis()
                )
            );
        }
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
   public ListeAnnonce selectByUser(@PathVariable int idUtilisateur)throws Exception{
        Connexion co = new Connexion();
        Connection connection = co.getConnex();
        ListeAnnonce annonce = new ListeAnnonce();
        ListeAnnonce listeAnnonce = annonce.listeAnnonceParUtilisateur(connection,idUtilisateur);
        connection.close();
        return listeAnnonce;
   }

   @GetMapping("/selectAnnonce")
   public List<ListeAnnonce> selectAllAnnonce()throws Exception{
        Connexion connexion= new Connexion();
        Connection connection =connexion.getConnex();
        ListeAnnonce annonceDetail= new ListeAnnonce();
        List<ListeAnnonce> listeDetails= annonceDetail.listeAnnonce(connection);
        connection.close();
        return listeDetails;
   }
   
   @GetMapping("/recherche")
    public List<AnnonceDetail> rechercheAnnonce(@RequestParam String prixMin , @RequestParam String prixMax ,@RequestParam String idBoitedevitesse , @RequestParam String idCarburant , @RequestParam String idCategorie , @RequestParam String idLieu , @RequestParam String idMarque  , @RequestParam String idModel  ){
        return annonceDetailRepository.rechercheAnnonce(prixMin ,   prixMax ,  idBoitedevitesse ,  idCarburant ,   idCategorie ,   idLieu ,   idMarque  ,   idModel);
    } 

    @GetMapping("/historiqueAnnonce")
    public List<AnnonceDetail> historiqueAnnonceUtilisateur(@RequestParam int idCreateur) {
        return annonceRepository.historiqueAnnonceUtilisateur(idCreateur);
    }

    @PostMapping("/modificationStatuAnnonce")
    public Annonce ChangerStatuAnnonce(@RequestParam int idAnnonce,@RequestParam int etat){
        return this.annonceService.ModificationStatuAnnonce(idAnnonce,etat);
    }

    @GetMapping("/listeAnnonceAModifier")
    public List<ListeAnnonce> listeAnnonceAValider() throws Exception{
        ListeAnnonce annonceDetail= new ListeAnnonce();
        List<ListeAnnonce> listeDetails= annonceDetail.listeAnnonceAValider(null);
        return listeDetails;
    }

    @GetMapping("/listeAnnoncePhoto")
    public List<AnnonceAvecPhoto> listeAnnoncePicture()throws Exception{
        Connexion connexion= new Connexion();
        Connection connection =connexion.getConnex();
        AnnonceAvecPhoto util= new AnnonceAvecPhoto();
        List<AnnonceAvecPhoto> liste = util.listeAnnonceWithPhoto(connection);
        connection.close();
        return liste;
    }
    
}
