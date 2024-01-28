package com.voiture.voiture.modele;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Couleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcouleur")
    int IdCouleur ;

    @Column(name="nomcouleur")
    String NomCouleur ;

    

    public Couleur(int idCouleur, String nomCouleur) {
        IdCouleur = idCouleur;
        NomCouleur = nomCouleur;
    }

    public Couleur() {
    }

    public int getIdCouleur() {
        return IdCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        IdCouleur = idCouleur;
    }

    public String getNomCouleur() {
        return NomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        NomCouleur = nomCouleur;
    }

    

}
