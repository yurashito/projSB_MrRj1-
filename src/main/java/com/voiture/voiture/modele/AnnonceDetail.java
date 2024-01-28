package com.voiture.voiture.modele;

import java.sql.Timestamp;

public class AnnonceDetail {
    
    int IdAnnonce;
    String Description;
    Timestamp  DateHeureAnnonce ;
    String Imatricule ;
    int  IdCouleur ;
    String  Couleur; 
    int  IdCreateur ; 
    String NomCreateur ;
    int IdLieu ;
    String NomLieu;
    String Annee;
    double Prix ;
    double PourcentageAlaina;
    int EtatAnnonce;

    public int getIdAnnonce() {
        return IdAnnonce;
    }
    public void setIdAnnonce(int idAnnonce) {
        IdAnnonce = idAnnonce;
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
    public int getIdCouleur() {
        return IdCouleur;
    }
    public void setIdCouleur(int idCouleur) {
        IdCouleur = idCouleur;
    }
    public String getCouleur() {
        return Couleur;
    }
    public void setCouleur(String couleur) {
        Couleur = couleur;
    }
    public int getIdCreateur() {
        return IdCreateur;
    }
    public void setIdCreateur(int idCreateur) {
        IdCreateur = idCreateur;
    }
    public String getNomCreateur() {
        return NomCreateur;
    }
    public void setNomCreateur(String nomCreateur) {
        NomCreateur = nomCreateur;
    }
    public int getIdLieu() {
        return IdLieu;
    }
    public void setIdLieu(int idLieu) {
        IdLieu = idLieu;
    }
    public String getNomLieu() {
        return NomLieu;
    }
    public void setNomLieu(String nomLieu) {
        NomLieu = nomLieu;
    }
    public String getAnnee() {
        return Annee;
    }
    public void setAnnee(String annee) {
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
    public Timestamp getDateHeureAnnonce() {
        return DateHeureAnnonce;
    }
    public void setDateHeureAnnonce(Timestamp dateHeureAnnonce) {
        DateHeureAnnonce = dateHeureAnnonce;
    }

    

}
