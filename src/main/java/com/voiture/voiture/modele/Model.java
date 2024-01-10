package com.voiture.voiture.modele;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmodel")
    int IdModel ;

    @Column(name="nommodel")
    String NomModel ;

    @Column(name = "etat")
    int Etat;

    

    public Model(int idModel) {
        IdModel = idModel;
    }

    public Model(int idModel, String nomModel) {
        IdModel = idModel;
        NomModel = nomModel;
    }

    public Model() {
    }

    public int getIdModel() {
        return IdModel;
    }

    public void setIdModel(int idModel) {
        IdModel = idModel;
    }

    public String getNomModel() {
        return NomModel;
    }

    public void setNomModel(String nomModel) {
        NomModel = nomModel;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    
}
