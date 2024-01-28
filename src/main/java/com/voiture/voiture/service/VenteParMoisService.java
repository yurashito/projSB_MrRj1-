package com.voiture.voiture.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.VenteParMois;
import com.voiture.voiture.repository.VenteParMoisRepository;

import java.util.List;

@Service
public class VenteParMoisService {

    private final VenteParMoisRepository venteParMoisRepository;

    @Autowired
    public VenteParMoisService(VenteParMoisRepository venteParMoisRepository) {
        this.venteParMoisRepository = venteParMoisRepository;
    }

    public List<VenteParMois> getAllVentesParMois() {
        return venteParMoisRepository.findAll();
    }
}

