package com.voiture.voiture.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idlieu")
    int IdLieu ;

    @Column(name="nomlieu")
    String NomLieu ;

    @Column(name = "etat")
    int Etat;
    
    

    public Lieu(int idLieu) {
        IdLieu = idLieu;
    }

    public Lieu() {
    }

    public Lieu(int idLieu, String nomLieu) {
        IdLieu = idLieu;
        NomLieu = nomLieu;
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

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    
}
