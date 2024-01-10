package com.voiture.voiture.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmarque")
    int IdMarque;
    
    @Column(name="nommarque")
    String NomMarque ;

    @Column(name = "etat")
    int Etat;

    

    public Marque(int idMarque) {
        IdMarque = idMarque;
    }

    public Marque(int idMarque, String nomMarque) {
        IdMarque = idMarque;
        NomMarque = nomMarque;
    }

    public Marque() {
    }

    public int getIdMarque() {
        return IdMarque;
    }

    public void setIdMarque(int idMarque) {
        IdMarque = idMarque;
    }

    public String getNomMarque() {
        return NomMarque;
    }

    public void setNomMarque(String nomMarque) {
        NomMarque = nomMarque;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    
}
