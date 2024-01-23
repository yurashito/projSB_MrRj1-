package com.voiture.voiture.modele;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnnonceParUtilisateur {
    int idUtilisateur;
    String nomUtilisateur;
    LocalDateTime dateHeureAnnonce;
    String description;
    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    public LocalDateTime getDateHeureAnnonce() {
        return dateHeureAnnonce;
    }
    public void setDateHeureAnnonce(LocalDateTime dateHeureAnnonce) {
        this.dateHeureAnnonce = dateHeureAnnonce;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    

    public void setDate (String dates) throws Exception{

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            this.dateHeureAnnonce = LocalDateTime.parse(dates, formatter);
             

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public AnnonceParUtilisateur() {
    }
    public AnnonceParUtilisateur(int idUtilisateur, String nomUtilisateur, LocalDateTime dateHeureAnnonce,
            String description) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.dateHeureAnnonce = dateHeureAnnonce;
        this.description = description;
    }

    public AnnonceParUtilisateur(int idUtilisateur, String nomUtilisateur, String dateHeureAnnonce,
            String description)throws Exception {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.setDate(dateHeureAnnonce); 
        this.description = description;
    }


    
}
