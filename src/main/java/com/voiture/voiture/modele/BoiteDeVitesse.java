package com.voiture.voiture.modele;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boitedevitesse")
public class BoiteDeVitesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idboitedevitesse")
    int IdBoiteDeVitesse ;

    @Column(name="nomboitedevitesse")
    String NomBoiteDeVitesse ;

    @Column(name = "etat")
    int Etat;
    
    

    public BoiteDeVitesse(int idBoiteDeVitesse, String nomBoiteDeVitesse, int etat) {
        IdBoiteDeVitesse = idBoiteDeVitesse;
        NomBoiteDeVitesse = nomBoiteDeVitesse;
        Etat = etat;
    }

    public BoiteDeVitesse(int idBoiteDeVitesse) {
        IdBoiteDeVitesse = idBoiteDeVitesse;
    }

    public BoiteDeVitesse(int idBoiteDeVitesse, String nomBoiteDeVitesse) {
        IdBoiteDeVitesse = idBoiteDeVitesse;
        NomBoiteDeVitesse = nomBoiteDeVitesse;
    }

    public BoiteDeVitesse() {
    }

    public int getIdBoiteDeVitesse() {
        return IdBoiteDeVitesse;
    }

    public void setIdBoiteDeVitesse(int idBoiteDeVitesse) {
        IdBoiteDeVitesse = idBoiteDeVitesse;
    }

    public String getNomBoiteDeVitesse() {
        return NomBoiteDeVitesse;
    }

    public void setNomBoiteDeVitesse(String nomBoiteDeVitesse) {
        NomBoiteDeVitesse = nomBoiteDeVitesse;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    


}
