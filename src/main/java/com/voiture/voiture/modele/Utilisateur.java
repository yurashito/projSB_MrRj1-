package com.voiture.voiture.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idutilisateur")
    int IdUtilisateur;
    
    @Column(name="nomutilisateur")
    String NomUtilisateur ;

    @Column(name = "prenomutilisateur")
    String PrenomUtilisateur;
    
    @Column(name = "mail")
    String Mail;

    
    @Column(name = "mdp")
    String Mdp;

    
    @Column(name = "numero")
    String Numero;

    
    @Column(name = "identifiant")
    int Identifiant;

    

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String mail, String mdp, String numero) {
        NomUtilisateur = nomUtilisateur;
        PrenomUtilisateur = prenomUtilisateur;
        Mail = mail;
        Mdp = mdp;
        Numero = numero;
    }


    public Utilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }


    public Utilisateur() {
    }


    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String mail, String mdp,
            String numero, int identifiant) {
        IdUtilisateur = idUtilisateur;
        NomUtilisateur = nomUtilisateur;
        PrenomUtilisateur = prenomUtilisateur;
        Mail = mail;
        Mdp = mdp;
        Numero = numero;
        Identifiant = identifiant;
    }


    public int getIdUtilisateur() {
        return IdUtilisateur;
    }


    public void setIdUtilisateur(int idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }


    public String getNomUtilisateur() {
        return NomUtilisateur;
    }


    public void setNomUtilisateur(String nomUtilisateur) {
        NomUtilisateur = nomUtilisateur;
    }


    public String getPrenomUtilisateur() {
        return PrenomUtilisateur;
    }


    public void setPrenomUtilisateur(String prenomUtilisateur) {
        PrenomUtilisateur = prenomUtilisateur;
    }


    public String getMail() {
        return Mail;
    }


    public void setMail(String mail) {
        Mail = mail;
    }


    public String getMdp() {
        return Mdp;
    }


    public void setMdp(String mdp) {
        Mdp = mdp;
    }


    public String getNumero() {
        return Numero;
    }


    public void setNumero(String numero) {
        Numero = numero;
    }


    public int getIdentifiant() {
        return Identifiant;
    }


    public void setIdentifiant(int identifiant) {
        Identifiant = identifiant;
    }

    
    
    
    

    
    
   
    

   
}
