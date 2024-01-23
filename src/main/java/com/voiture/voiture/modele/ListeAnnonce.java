package com.voiture.voiture.modele;
import java.sql.*;

public class ListeAnnonce {
    String nom;
    Date date;
    int idVoiture;
    String imatricule;
    String couleur;
    String nomCreateur;
    String nomLieu;
    int annee;
    double prix;
    int etatAnnonce;
    public ListeAnnonce(String nom, Date date, int idVoiture, String imatricule, String couleur, String nomCreateur,
            String nomLieu, int annee, double prix, int etatAnnonce) {
        this.nom = nom;
        this.date = date;
        this.idVoiture = idVoiture;
        this.imatricule = imatricule;
        this.couleur = couleur;
        this.nomCreateur = nomCreateur;
        this.nomLieu = nomLieu;
        this.annee = annee;
        this.prix = prix;
        this.etatAnnonce = etatAnnonce;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getIdVoiture() {
        return idVoiture;
    }
    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }
    public String getImatricule() {
        return imatricule;
    }
    public void setImatricule(String imatricule) {
        this.imatricule = imatricule;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public String getNomCreateur() {
        return nomCreateur;
    }
    public void setNomCreateur(String nomCreateur) {
        this.nomCreateur = nomCreateur;
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
    public int getEtatAnnonce() {
        return etatAnnonce;
    }
    public void setEtatAnnonce(int etatAnnonce) {
        this.etatAnnonce = etatAnnonce;
    }
    
       
}
