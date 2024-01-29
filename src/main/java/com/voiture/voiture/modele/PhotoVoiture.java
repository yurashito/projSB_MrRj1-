package com.voiture.voiture.modele;

public class PhotoVoiture {
  int idPhotoVoiture;  
  int idAnnonce;
  String nomPhotoVoiture;
  public int getIdPhotoVoiture() {
    return idPhotoVoiture;
  }
  public void setIdPhotoVoiture(int idPhotoVoiture) {
    this.idPhotoVoiture = idPhotoVoiture;
  }
  public int getIdAnnonce() {
    return idAnnonce;
  }
  public void setIdAnnonce(int idAnnonce) {
    this.idAnnonce = idAnnonce;
  }
  public String getNomPhotoVoiture() {
    return nomPhotoVoiture;
  }
  public void setNomPhotoVoiture(String nomPhotoVoiture) {
    this.nomPhotoVoiture = nomPhotoVoiture;
  }
public PhotoVoiture() {
}
public PhotoVoiture(int idPhotoVoiture, int idAnnonce, String nomPhotoVoiture) {
  this.idPhotoVoiture = idPhotoVoiture;
  this.idAnnonce = idAnnonce;
  this.nomPhotoVoiture = nomPhotoVoiture;
}

// Constructeur sans ID
public PhotoVoiture(int idAnnonce, String nomPhotoVoiture) {
  this.idAnnonce = idAnnonce;
  this.nomPhotoVoiture = nomPhotoVoiture;
}  

  
}
