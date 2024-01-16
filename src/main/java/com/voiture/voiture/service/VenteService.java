package com.voiture.voiture.service;

import javax.persistence.Query;

import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
 


import com.voiture.voiture.repository.VenteRepostory;
import java.sql.Date;

@Service
public class VenteService {
    private final  VenteRepostory venteRepostory;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public VenteService(VenteRepostory venteRepository) {
        this.venteRepostory = venteRepository;
    }

    public long getNombreVentesDansMois(Date debutMois, Date finMois) {
        String queryString = "SELECT COUNT(*) FROM Vente WHERE DateVente BETWEEN :debutMois AND :finMois";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("debutMois", debutMois);
        query.setParameter("finMois", finMois);

        // Exécution de la requêtes
        return (long) query.getSingleResult();
    }


}
