package com.voiture.voiture.modele;

import java.sql.*;
import java.util.*;

import com.voiture.voiture.connex.Connexion;

public class AnnonceAvecPhoto {
    int idAnnonce;
    Timestamp dateHeure;
    String description;
    String imatricule;
    String nomCategorie;
    String nomMarque;
    String nomCarburant;
    String nomModel;
    String nomBoiteDeVitesse;
    String nomCouleur;
    String nomUtilisteur;
    String nomLieu;
    int annee;
    double prix;
    int pourcentage;
    int etatAnnonce;
    List<PhotoVoiture> photoVoiture;
    public AnnonceAvecPhoto() {
    }
    public AnnonceAvecPhoto(int idAnnonce, Timestamp dateHeure, String description, String imatricule,
            String nomCategorie, String nomMarque, String nomCarburant, String nomModel, String nomBoiteDeVitesse,
            String nomCouleur, String nomUtilisteur, String nomLieu, int annee, double prix, int pourcentage,
            int etatAnnonce, List<PhotoVoiture> photoVoiture) {
        this.idAnnonce = idAnnonce;
        this.dateHeure = dateHeure;
        this.description = description;
        this.imatricule = imatricule;
        this.nomCategorie = nomCategorie;
        this.nomMarque = nomMarque;
        this.nomCarburant = nomCarburant;
        this.nomModel = nomModel;
        this.nomBoiteDeVitesse = nomBoiteDeVitesse;
        this.nomCouleur = nomCouleur;
        this.nomUtilisteur = nomUtilisteur;
        this.nomLieu = nomLieu;
        this.annee = annee;
        this.prix = prix;
        this.pourcentage = pourcentage;
        this.etatAnnonce = etatAnnonce;
        this.photoVoiture = photoVoiture;
    }
    public AnnonceAvecPhoto(Timestamp dateHeure, String description, String imatricule, String nomCategorie,
            String nomMarque, String nomCarburant, String nomModel, String nomBoiteDeVitesse, String nomCouleur,
            String nomUtilisteur, String nomLieu, int annee, double prix, int pourcentage, int etatAnnonce,
            List<PhotoVoiture>photoVoiture) {
        this.dateHeure = dateHeure;
        this.description = description;
        this.imatricule = imatricule;
        this.nomCategorie = nomCategorie;
        this.nomMarque = nomMarque;
        this.nomCarburant = nomCarburant;
        this.nomModel = nomModel;
        this.nomBoiteDeVitesse = nomBoiteDeVitesse;
        this.nomCouleur = nomCouleur;
        this.nomUtilisteur = nomUtilisteur;
        this.nomLieu = nomLieu;
        this.annee = annee;
        this.prix = prix;
        this.pourcentage = pourcentage;
        this.etatAnnonce = etatAnnonce;
        this.photoVoiture = photoVoiture;
    }
    public int getIdAnnonce() {
        return idAnnonce;
    }
    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }
    public Timestamp getDateHeure() {
        return dateHeure;
    }
    public void setDateHeure(Timestamp dateHeure) {
        this.dateHeure = dateHeure;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImatricule() {
        return imatricule;
    }
    public void setImatricule(String imatricule) {
        this.imatricule = imatricule;
    }
    public String getNomCategorie() {
        return nomCategorie;
    }
    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    public String getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
    public String getNomCarburant() {
        return nomCarburant;
    }
    public void setNomCarburant(String nomCarburant) {
        this.nomCarburant = nomCarburant;
    }
    public String getNomModel() {
        return nomModel;
    }
    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }
    public String getNomBoiteDeVitesse() {
        return nomBoiteDeVitesse;
    }
    public void setNomBoiteDeVitesse(String nomBoiteDeVitesse) {
        this.nomBoiteDeVitesse = nomBoiteDeVitesse;
    }
    public String getNomCouleur() {
        return nomCouleur;
    }
    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }
    public String getNomUtilisteur() {
        return nomUtilisteur;
    }
    public void setNomUtilisteur(String nomUtilisteur) {
        this.nomUtilisteur = nomUtilisteur;
    }
    public String getNomLieu() {
        return nomLieu;
    }
    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getPourcentage() {
        return pourcentage;
    }
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }
    public int getEtatAnnonce() {
        return etatAnnonce;
    }
    public void setEtatAnnonce(int etatAnnonce) {
        this.etatAnnonce = etatAnnonce;
    }
    public List<PhotoVoiture> getPhotoVoiture() {
        return photoVoiture;
    }
    public void setPhotoVoiture(List<PhotoVoiture> photoVoiture) {
        this.photoVoiture = photoVoiture;
    }

    public void getListePhoto (Connection connection)throws Exception{
       
        String sql = "SELECT * FROM photovoiture WHERE idannonce=?";
        if(connection == null || connection.isClosed()){
            connection = Connexion.getConnex();
        }
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,this.getIdAnnonce());
            this.photoVoiture = new ArrayList<>();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int idAnnonces = resultSet.getInt("idAnnonce");
                    String nomPhotoVoiture = resultSet.getString("nomPhoto");
                    PhotoVoiture photoVoiture1 = new PhotoVoiture(idAnnonces, nomPhotoVoiture);
                    this.photoVoiture.add(photoVoiture1);
                    
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
    
        }
        finally{
            if(connection==null){
                connection.close();
            }
        }
    
    }
    

    public AnnonceAvecPhoto(int idAnnonce, Timestamp dateHeure, String description, String imatricule, String nomCouleur, String nomUtilisteur, String nomLieu, int annee, double prix, int etatAnnonce) {
        this.idAnnonce = idAnnonce;
        this.dateHeure = dateHeure;
        this.description = description;
        this.imatricule = imatricule;
        this.nomCouleur = nomCouleur;
        this.nomUtilisteur = nomUtilisteur;
        this.nomLieu = nomLieu;
        this.annee = annee;
        this.prix = prix;
        this.etatAnnonce = etatAnnonce;
    }
    public List<AnnonceAvecPhoto> listeAnnonceWithPhoto (Connection connection)throws Exception{
        String sql= "SELECT * FROM V_annonce";
        List<AnnonceAvecPhoto> listes = new ArrayList<>();
        
        if(connection == null || connection.isClosed()){
            connection = Connexion.getConnex();
        }
        
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                Timestamp dateHeure = resultSet.getTimestamp("dateheureannonce");
                String description = resultSet.getString("description");
                String imatricule = resultSet.getString("imatricule");
                // String nomCategorie = resultSet.getString("nomcategorie");
                // String nomMarque = resultSet.getString("nomMarque");
                // String nomCarburant= resultSet.getString("nomCarburant");
                // String nomModel = resultSet.getString("nomModel");
                // String nomBoiteDeVitesse= resultSet.getString("nomBoiteDeVitesse");
                String nomCouleur= resultSet.getString("couleur");
                String nomUtilisteur = resultSet.getString("nomCreateur");
                String nomLieu = resultSet.getString("nomLieu");
                int annee = resultSet.getInt("annee") ;
                double prix = resultSet.getDouble("prix");
                // int pourcentage = resultSet.getInt("pourcentage") ;
                int etatAnnonce = resultSet.getInt("etatAnnonce");
                
                AnnonceAvecPhoto annonceWithPictures = new AnnonceAvecPhoto( idAnnonce, dateHeure, description, imatricule, nomCouleur, nomUtilisteur, nomLieu, annee,prix, etatAnnonce);
                annonceWithPictures.getListePhoto(connection);

                listes.add(annonceWithPictures);
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();

    }
    finally{
        if(connection==null){
            connection.close();
        }
    }

    return listes;       

    }
    
}

    
}
