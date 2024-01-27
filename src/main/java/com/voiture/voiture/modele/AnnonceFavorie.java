package com.voiture.voiture.modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import com.voiture.voiture.connex.Connexion;



public class AnnonceFavorie {
     
     String description;
     Timestamp dateHeureAnnonce;
     int annee;
     double prix;
     String imatricule;
     String nomUtilisateur;
     String nomLieu;
     int idFavorie;
    
     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateHeureAnnonce() {
        return dateHeureAnnonce;
    }

    public void setDateHeureAnnonce(Timestamp dateHeureAnnonce) {
        this.dateHeureAnnonce = dateHeureAnnonce;
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
    
    public AnnonceFavorie(String description, Timestamp dateHeureAnnonce, int annee, double prix, String imatricule,
            String nomUtilisateur, String nomLieu, int idFavorie) {
        this.description = description;
        this.dateHeureAnnonce = dateHeureAnnonce;
        this.annee = annee;
        this.prix = prix;
        this.imatricule = imatricule;
        this.nomUtilisateur = nomUtilisateur;
        this.nomLieu = nomLieu;
        this.idFavorie = idFavorie;
    }

    public AnnonceFavorie() {
    }

    public AnnonceFavorie AnnonceFavorie (Connection connexion, int idUtilisateur) throws Exception{

        String sql="SELECT * FROM V_Annonce_Favorie WHERE idCreateur=?";        
        

        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
        }
 
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idUtilisateur);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             if (resultSet.next()) {
                String description = resultSet.getString("description");
                Timestamp dateheure = resultSet.getTimestamp("dateheureannonce");
                int annee= resultSet.getInt("annee");
                double prix = resultSet.getDouble("prix");
                String nomUtilisateur = resultSet.getString("nomcreateur");
                String nomLieu = resultSet.getString("nomlieu");
                int idFavorie = resultSet.getInt("idfavorie");
//              
                AnnonceFavorie annonceFavorie = new AnnonceFavorie( description,dateheure,annee,prix,imatricule,nomUtilisateur,nomLieu,idFavorie);
                
                return annonceFavorie;
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    return null;       

    }
}



}
