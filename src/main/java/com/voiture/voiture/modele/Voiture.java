package com.voiture.voiture.modele;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Voiture {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "idVioture")
   int idVoiture;

    @Column(name = "idMatricule")
    int idMatricule;

    @Column(name = "idCategorie")
    int idCategorie;

    @Column(name = "idMarque")
    int idMarque;

    @Column(name = "idCarburant")
    int idCarburant;

    @Column(name = "idModel")
    int idModel;

    @Column (name = "idBoiteDeVitesse")
    int idBoiteDeVitesse;

    @Column(name= "idCouleur")
    int idCouleur;

    public Voiture() {
    }

    // Constructeur avec tous les attributs
    public Voiture(int idVoiture, int idMatricule, int idCategorie, int idMarque, int idCarburant, int idModel,
                   int idBoiteDeVitesse, int idCouleur) {
        this.idVoiture = idVoiture;
        this.idMatricule = idMatricule;
        this.idCategorie = idCategorie;
        this.idMarque = idMarque;
        this.idCarburant = idCarburant;
        this.idModel = idModel;
        this.idBoiteDeVitesse = idBoiteDeVitesse;
        this.idCouleur = idCouleur;
    }

    // Constructeur sans l'attribut idVoiture
    public Voiture(int idMatricule, int idCategorie, int idMarque, int idCarburant, int idModel,
                   int idBoiteDeVitesse, int idCouleur) {
        this.idMatricule = idMatricule;
        this.idCategorie = idCategorie;
        this.idMarque = idMarque;
        this.idCarburant = idCarburant;
        this.idModel = idModel;
        this.idBoiteDeVitesse = idBoiteDeVitesse;
        this.idCouleur = idCouleur;
    }

    // Getters et setters pour tous les attributs

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public int getIdMatricule() {
        return idMatricule;
    }

    public void setIdMatricule(int idMatricule) {
        this.idMatricule = idMatricule;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public int getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(int idCarburant) {
        this.idCarburant = idCarburant;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public int getIdBoiteDeVitesse() {
        return idBoiteDeVitesse;
    }

    public void setIdBoiteDeVitesse(int idBoiteDeVitesse) {
        this.idBoiteDeVitesse = idBoiteDeVitesse;
    }

    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

}
