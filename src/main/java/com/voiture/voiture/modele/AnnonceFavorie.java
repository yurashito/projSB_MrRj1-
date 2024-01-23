package com.voiture.voiture.modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.voiture.voiture.connex.Connexion;



public class AnnonceFavorie {
     Date dateHeureAnnonce;
     String description;
     int annee;
     Double prix;
     String imatricule;
     String nomUtilisateur;
     String nomLieu;
     int idFavorie;
    
    
    
     public AnnonceFavorie() {
    }

    public AnnonceFavorie(Date dateHeureAnnonce, String description, int annee, Double prix, String imatricule,
            String nomUtilisateur, String nomLieu, int idFavorie) {
        this.dateHeureAnnonce = dateHeureAnnonce;
        this.description = description;
        this.annee = annee;
        this.prix = prix;
        this.imatricule = imatricule;
        this.nomUtilisateur = nomUtilisateur;
        this.nomLieu = nomLieu;
        this.idFavorie = idFavorie;
    }

    public AnnonceFavorie(Date dateHeureAnnonce, String description, int annee, Double prix, String imatricule,
            String nomUtilisateur, String nomLieu) {
        this.dateHeureAnnonce = dateHeureAnnonce;
        this.description = description;
        this.annee = annee;
        this.prix = prix;
        this.imatricule = imatricule;
        this.nomUtilisateur = nomUtilisateur;
        this.nomLieu = nomLieu;
        
    }

    public Date getDateHeureAnnonce() {
        return dateHeureAnnonce;
    }
    public void setDateHeureAnnonce(Date dateHeureAnnonce) {
        this.dateHeureAnnonce = dateHeureAnnonce;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public String getImatricule() {
        return imatricule;
    }
    public void setImatricule(String imatricule) {
        this.imatricule = imatricule;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public String getNomLieu() {
        return nomLieu;
    }
    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }
    public int getIdFavorie() {
        return idFavorie;
    }
    public void setIdFavorie(int idFavorie) {
        this.idFavorie = idFavorie;
    }

     
    public List<AnnonceFavorie> Favorie (Connection connexion) throws Exception{

        String sql="SELECT * FROM view_annonce_favori";        
        List<AnnonceFavorie> listeAnnonceFavories = new ArrayList<>();

        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
        }

        
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                Date date = resultSet.getDate("dateheureannonce");
                String nom = resultSet.getString("description");
                int annee = resultSet.getInt("annee");
                double prix = resultSet.getDouble("prix");
                String imatricule = resultSet.getString("imatricule");
                String utilisateur = resultSet.getString("nomutilisateur");
                String nomLieu= resultSet.getString("nomlieu");
//                    public EtatPersonne(int idEtatPersonne, Date date, int idPersonne, int idDent, int etat) {
                AnnonceFavorie annonceFavorie = new AnnonceFavorie( date,nom,annee,prix,imatricule,utilisateur,nomLieu);
                
                listeAnnonceFavories.add(annonceFavorie);
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    return listeAnnonceFavories;       

    }
}



}
