package com.voiture.voiture.modele;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcarburant")
    int IdCarburant ;

    @Column(name="nomcarburant")
    String NomCarburant ;

    @Column(name = "etat")
    int Etat;
    
    

    public Carburant(int idCarburant) {
        IdCarburant = idCarburant;
    }

    public Carburant() {
    }

    public Carburant(int idCarburant, String nomCarburant) {
        IdCarburant = idCarburant;
        NomCarburant = nomCarburant;
    }

    public int getIdCarburant() {
        return IdCarburant;
    }

    public void setIdCarburant(int idCarburant) {
        IdCarburant = idCarburant;
    }

    public String getNomCarburant() {
        return NomCarburant;
    }

    public void setNomCarburant(String nomCarburant) {
        NomCarburant = nomCarburant;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    

}
