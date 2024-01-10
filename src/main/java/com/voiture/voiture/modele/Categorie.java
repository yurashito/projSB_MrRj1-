package com.voiture.voiture.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcategorie")
    int IdCategorie ;

    @Column(name="nomcategorie")
    String NomCategorie ;

    @Column(name = "etat")
    int Etat;

    

    public Categorie(int idCategorie) {
        IdCategorie = idCategorie;
    }
    public Categorie(int idCategorie, String nomCategorie) {
        IdCategorie = idCategorie;
        NomCategorie = nomCategorie;
    }
    public Categorie() {
    }
    public int getIdCategorie() {
        return IdCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }
    public String getNomCategorie() {
        return NomCategorie;
    }
    public void setNomCategorie(String nomCategorie) {
        NomCategorie = nomCategorie;
    }
    public int getEtat() {
        return Etat;
    }
    public void setEtat(int etat) {
        Etat = etat;
    }

    
}
