package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.UtilisateurRepository;
import com.voiture.voiture.modele.*;

@Service
public class UtilisateurService {
    private final UtilisateurRepository UtilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository UtilisateurRepository) {
        this.UtilisateurRepository = UtilisateurRepository;
    }

    public List<Utilisateur> select(){
        return this.UtilisateurRepository.findAll();
    }

    public Utilisateur Creer(Utilisateur favorie){
        return UtilisateurRepository.save(favorie);
    }

    public Utilisateur update(int idUtilisateur,Utilisateur modifier){
        return this.UtilisateurRepository.findById(idUtilisateur).map(
            categorie ->{
                // categorie.setIdUtilisateur(modifier.getIdUtilisateur());
                categorie.setNomUtilisateur(modifier.getNomUtilisateur());
                categorie.setIdentifiant(modifier.getIdentifiant());
                return UtilisateurRepository.save(categorie);
            }
        ).orElseThrow(() -> new RuntimeException("Utilisateur pas trouver"));
    }
    // public boolean verifUtilisateur(String nom , String mdp){
    //     if(UtilisateurRepository.verifierUtilisateur(nom, mdp)!=null){
    //         return true;
    //     }
    //     return false;
    // }

    public Utilisateur verifUtilisateur(String nom , String mdp){
        Utilisateur utilisateur = UtilisateurRepository.verifierUtilisateur(nom, mdp);
        System.out.println("nom utilisateur :   "+utilisateur.getNomUtilisateur());
        if(utilisateur!=null){
            return utilisateur ;
        }
        return utilisateur;
    }
}
