package com.voiture.voiture.modele;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVente")
    int idVente;

    @Column(name="idVoiture")
    int idVoiture;

    @Column(name="prixVoiture")
    double prixVoiture;

    @Column(name = "dateVente")
    Date dateVente;
    

    // Constructeur avec tous les attributs
    public Vente(int idVente, int idVoiture, double prixVoiture, Date dateVente) {
        this.idVente = idVente;
        this.idVoiture = idVoiture;
        this.prixVoiture = prixVoiture;
        this.dateVente = dateVente;
    }

    // Constructeur sans l'attribut idVente
    public Vente(int idVoiture, double prixVoiture, Date dateVente) {
        this.idVoiture = idVoiture;
        this.prixVoiture = prixVoiture;
        this.dateVente = dateVente;
    }

    // Méthodes Getter
    public int getIdVente() {
        return idVente;
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public double getPrixVoiture() {
        return prixVoiture;
    }

    public Date getDateVente() {
        return dateVente;
    }

    // Méthodes Setter
    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public void setPrixVoiture(double prixVoiture) {
        this.prixVoiture = prixVoiture;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }


    
}
