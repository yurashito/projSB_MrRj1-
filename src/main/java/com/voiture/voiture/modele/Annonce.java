package com.voiture.voiture.modele;

import javax.persistence.Entity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.voiture.voiture.connex.Connexion;

@Entity
@Table(name="annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idannonce")
    int Annonce;
    
    @Column(name="dateheureannonce" , columnDefinition = "timestamp DEFAULT now()")
    Timestamp DateHeureAnnonce ;

    @Column(name="description")
    String Description ;

    @Column(name="imatricule")
    String Imatricule ;

    @Column(name="idcategorie")
    int IdCategorie ;
    
    @Column(name="idmarque")
    int IdMarque ;

    @Column(name="idcarburant")
    int IdCarburant ;

    @Column(name="idmodel")
    int IdModel ;

    @Column(name="idboitedevitesse")
    int IdBoiteDeVitesse ;

    @Column(name="idcouleur")
    int IdCouleur ;

    @Column(name="idcreateur")
    int IdCreateur ;

    @Column(name="idlieu")
    int IdLieu ;

    @Column(name="annee")
    double Annee ;

    @Column(name="prix")
    double Prix ;

    @Column(name="pourcentagealaina")
    double PourcentageAlaina ;

    @Column(name="etatannonce")
    int EtatAnnonce ;

   


    public int getAnnonce() {
        return Annonce;
    }

    public void setAnnonce(int annonce) {
        Annonce = annonce;
    }

    public Timestamp getDateHeureAnnonce() {
        return DateHeureAnnonce;
    }

    public void setDateHeureAnnonce(Timestamp dateHeureAnnonce) {
        DateHeureAnnonce = dateHeureAnnonce;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImatricule() {
        return Imatricule;
    }

    public void setImatricule(String imatricule) {
        Imatricule = imatricule;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    public int getIdMarque() {
        return IdMarque;
    }

    public void setIdMarque(int idMarque) {
        IdMarque = idMarque;
    }

    public int getIdCarburant() {
        return IdCarburant;
    }

    public void setIdCarburant(int idCarburant) {
        IdCarburant = idCarburant;
    }

    public int getIdModel() {
        return IdModel;
    }

    public void setIdModel(int idModel) {
        IdModel = idModel;
    }

    public int getIdBoiteDeVitesse() {
        return IdBoiteDeVitesse;
    }

    public void setIdBoiteDeVitesse(int idBoiteDeVitesse) {
        IdBoiteDeVitesse = idBoiteDeVitesse;
    }

    public int getIdCouleur() {
        return IdCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        IdCouleur = idCouleur;
    }

    public int getIdCreateur() {
        return IdCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        IdCreateur = idCreateur;
    }

    public int getIdLieu() {
        return IdLieu;
    }

    public void setIdLieu(int idLieu) {
        IdLieu = idLieu;
    }

    public double getAnnee() {
        return Annee;
    }

    public void setAnnee(double annee) {
        Annee = annee;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public double getPourcentageAlaina() {
        return PourcentageAlaina;
    }

    public void setPourcentageAlaina(double pourcentageAlaina) {
        PourcentageAlaina = pourcentageAlaina;
    }

    public int getEtatAnnonce() {
        return EtatAnnonce;
    }

    public void setEtatAnnonce(int etatAnnonce) {
        EtatAnnonce = etatAnnonce;
    }

    public Annonce(int annonce, Timestamp dateHeureAnnonce, String description, String imatricule, int idCategorie,
            int idMarque, int idCarburant, int idModel, int idBoitedevitesse, int idCouleur, int idCreateur, int idLieu,
            double annee, double prix, double pourcentageAlaina, int etatAnnonce) {
        Annonce = annonce;
        DateHeureAnnonce = dateHeureAnnonce;
        Description = description;
        Imatricule = imatricule;
        IdCategorie = idCategorie;
        IdMarque = idMarque;
        IdCarburant = idCarburant;
        IdModel = idModel;
        IdBoiteDeVitesse = idBoitedevitesse;
        IdCouleur = idCouleur;
        IdCreateur = idCreateur;
        IdLieu = idLieu;
        Annee = annee;
        Prix = prix;
        PourcentageAlaina = pourcentageAlaina;
        EtatAnnonce = etatAnnonce;
    }

    public AnnonceParUtilisateur get_annonce_by_utilisateur(Connection connexion, int idUtilisateur) throws Exception{
        
        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
         }
        Utilisateur utilisateur = new Utilisateur();
        idUtilisateur = utilisateur.getIdUtilisateur();
        String sql = "SELECT * FROM view_annoncePar_utilisateur WHERE idutilisateur = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                
                preparedStatement.setInt(1, idUtilisateur);
                
                
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if(resultSet.next()) {
                    int id = resultSet.getInt("idutilisateur");
                    String nomUtilisateur= resultSet.getString("nomutilisateur");
                    String dateHeurAnnonce = resultSet.getString("dateheureannonce");
                    String description = resultSet.getString("description");

                    AnnonceParUtilisateur parUtilisateur = new AnnonceParUtilisateur(id,nomUtilisateur,dateHeurAnnonce,description);
                    return parUtilisateur;      
                }
                
                
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connexion.close();
        }
        return null; 
    }



    public Annonce() {}


}