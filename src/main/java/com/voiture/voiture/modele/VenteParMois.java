package com.voiture.voiture.modele;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="venteparmois")
public class VenteParMois {

    @Id
    private int mois_chiffre;
    private String mois_lettre;
    @Column(name = "nombreventes")
    private int nombreVentes;

    // Constructors, getters, and setters

    public VenteParMois() {
    }

    public VenteParMois(int mois_chiffre, String mois_lettre, int nombreVentes) {
        this.mois_chiffre = mois_chiffre;
        this.mois_lettre = mois_lettre;
        this.nombreVentes = nombreVentes;
    }

    // Getters and Setters

    public int getMois_chiffre() {
        return mois_chiffre;
    }

    public void setMois_chiffre(int mois_chiffre) {
        this.mois_chiffre = mois_chiffre;
    }

    public String getMois_lettre() {
        return mois_lettre;
    }

    public void setMois_lettre(String mois_lettre) {
        this.mois_lettre = mois_lettre;
    }

    public int getNombreVentes() {
        return nombreVentes;
    }

    public void setNombreVentes(int nombreVentes) {
        this.nombreVentes = nombreVentes;
    }
}
