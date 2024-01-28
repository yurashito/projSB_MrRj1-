package com.voiture.voiture.modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;
import com.voiture.voiture.connex.Connexion;

public class ListeAnnonce {
    
    int IdAnnonce;
    String Description;
    Timestamp  DateHeureAnnonce ;
    String Imatricule ;
    String  Couleur; 
    String NomCreateur ;
    String NomLieu;
    int Annee;
    double Prix ;
    int EtatAnnonce;
    
    
    public int getIdAnnonce() {
        return IdAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        IdAnnonce = idAnnonce;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Timestamp getDateHeureAnnonce() {
        return DateHeureAnnonce;
    }

    public void setDateHeureAnnonce(Timestamp dateHeureAnnonce) {
        DateHeureAnnonce = dateHeureAnnonce;
    }

    public String getImatricule() {
        return Imatricule;
    }

    public void setImatricule(String imatricule) {
        Imatricule = imatricule;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }

    public String getNomCreateur() {
        return NomCreateur;
    }

    public void setNomCreateur(String nomCreateur) {
        NomCreateur = nomCreateur;
    }

    public String getNomLieu() {
        return NomLieu;
    }

    public void setNomLieu(String nomLieu) {
        NomLieu = nomLieu;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double prix) {
        Prix = prix;
    }

    public int getEtatAnnonce() {
        return EtatAnnonce;
    }

    public void setEtatAnnonce(int etatAnnonce) {
        EtatAnnonce = etatAnnonce;
    }
    

    public ListeAnnonce(int idAnnonce, String description, Timestamp dateHeureAnnonce, String imatricule,
            String couleur, String nomCreateur, String nomLieu, int annee, double prix, int etatAnnonce) {
        IdAnnonce = idAnnonce;
        Description = description;
        DateHeureAnnonce = dateHeureAnnonce;
        Imatricule = imatricule;
        Couleur = couleur;
        NomCreateur = nomCreateur;
        NomLieu = nomLieu;
        Annee = annee;
        Prix = prix;
        EtatAnnonce = etatAnnonce;
    }

    public ListeAnnonce() {
    }

    public List<ListeAnnonce> listeAnnonce (Connection connexion) throws Exception{

        String sql="SELECT * FROM V_Annonce";        
        List<ListeAnnonce> listeAnnonces = new ArrayList<>();

        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
        }
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                int idAnnonce = resultSet.getInt("idAnnonce");
                String description = resultSet.getString("description");
                Timestamp dateHeure = resultSet.getTimestamp("dateheureannonce");
                String imatricule = resultSet.getString("imatricule");
                String couleur = resultSet.getString("couleur");
                String nomCreateur = resultSet.getString("nomCreateur");
                String nomLieu= resultSet.getString("nomLieu");
                int annee = resultSet.getInt("annee") ;
                double prix = resultSet.getDouble("prix");
                int etatAnnonce = resultSet.getInt("etatAnnonce");
 
                ListeAnnonce annonce = new ListeAnnonce(idAnnonce,description,dateHeure,imatricule,couleur,nomCreateur,nomLieu,annee,prix,etatAnnonce);
                
                listeAnnonces.add(annonce);
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    return listeAnnonces;       

    }
}

public ListeAnnonce listeAnnonceParUtilisateur(Connection connexion, int idUtilisateur) throws Exception{
        
        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
         }
       
        String sql = "SELECT * FROM V_Annonce WHERE idcreateur = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                
                preparedStatement.setInt(1, idUtilisateur);
             
                ResultSet resultSet = preparedStatement.executeQuery();
                
                if(resultSet.next()) {
                    int idAnnonce = resultSet.getInt("idAnnonce");
                    String description = resultSet.getString("description");
                    Timestamp dateHeure = resultSet.getTimestamp("dateheureannonce");
                    String imatricule = resultSet.getString("imatricule");
                    String couleur = resultSet.getString("couleur");
                    String nomCreateur = resultSet.getString("nomCreateur");
                    String nomLieu= resultSet.getString("nomLieu");
                    int annee = resultSet.getInt("annee") ;
                    double prix = resultSet.getDouble("prix");
                    int etatAnnonce = resultSet.getInt("etatAnnonce");

                    ListeAnnonce annonceParUtilisateur = new ListeAnnonce(idAnnonce,description,dateHeure,imatricule,couleur,nomCreateur,nomLieu,annee,prix,etatAnnonce);
                    return annonceParUtilisateur;      
                }
                
                
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connexion.close();
        }
        return null; 
    }

    public List<ListeAnnonce> listeAnnonceAValider (Connection connexion) throws Exception{

        String sql="SELECT * FROM V_Annonce where etatAnnonce = 0";        
        List<ListeAnnonce> listeAnnonces = new ArrayList<>();

        if(connexion == null || connexion.isClosed()){
            connexion = Connexion.getConnex();
        }
        try(PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                int idAnnonce = resultSet.getInt("idAnnonce");
                String description = resultSet.getString("description");
                Timestamp dateHeure = resultSet.getTimestamp("dateheureannonce");
                String imatricule = resultSet.getString("imatricule");
                String couleur = resultSet.getString("couleur");
                String nomCreateur = resultSet.getString("nomCreateur");
                String nomLieu= resultSet.getString("nomLieu");
                int annee = resultSet.getInt("annee") ;
                double prix = resultSet.getDouble("prix");
                int etatAnnonce = resultSet.getInt("etatAnnonce");
 
                ListeAnnonce annonce = new ListeAnnonce(idAnnonce,description,dateHeure,imatricule,couleur,nomCreateur,nomLieu,annee,prix,etatAnnonce);
                
                listeAnnonces.add(annonce);
            }   
            
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    return listeAnnonces;       

    }
}
}
