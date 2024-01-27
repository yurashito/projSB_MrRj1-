package com.voiture.voiture.modele;

import javax.persistence.Entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import com.voiture.voiture.connex.Connexion;

@Entity
@Table(name="annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idannonce")
    int Annonce;

    @Column(name="dateheureannonce")
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
    int IdBoitedevitesse ;

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

    public int getIdBoitedevitesse() {
        return IdBoitedevitesse;
    }

    public void setIdBoitedevitesse(int idBoitedevitesse) {
        IdBoitedevitesse = idBoitedevitesse;
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
    // Annonce annonceFavorie = new Annonce(date, nom, voiture, imatricule,couleur,utilisateur, nomLieu,annee,prix,etatAnnonce );
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
        IdBoitedevitesse = idBoitedevitesse;
        IdCouleur = idCouleur;
        IdCreateur = idCreateur;
        IdLieu = idLieu;
        Annee = annee;
        Prix = prix;
        PourcentageAlaina = pourcentageAlaina;
        EtatAnnonce = etatAnnonce;
    }

    public Annonce() {}

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

    public List<ListeAnnonce> listeAnnonce (Connection connexion) throws Exception{

        String sql="SELECT * FROM V_Annonce";        
        List<ListeAnnonce> listeAnnonces = new ArrayList<>();

        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
        }

        
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                Date date = resultSet.getDate("dateheureannonce");
                String nom = resultSet.getString("description");
                int voiture = resultSet.getInt("idVoiture");
                String imatricule = resultSet.getString("imatricule");
                String couleur = resultSet.getString("couleur");
                String utilisateur = resultSet.getString("nomcreateur");
                String nomLieu= resultSet.getString("nomlieu");
                int annee = resultSet.getInt("annee") ;
                double prix = resultSet.getDouble("prix");
                int etatAnnonce = resultSet.getInt("etatannonce");
 
                ListeAnnonce annonce = new ListeAnnonce(nom, date, voiture, imatricule, couleur, utilisateur, nomLieu, annee, prix, etatAnnonce);
                
                listeAnnonces.add(annonce);
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    return listeAnnonces;       

    }
}



}