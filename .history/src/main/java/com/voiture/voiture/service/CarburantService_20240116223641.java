package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Carburant;
import com.voiture.voiture.modele.Lieu;
import com.voiture.voiture.repository.CarburantRepository;


@Service
public class CarburantService {
    private final CarburantRepository carburantRepository;

    @Autowired
    public CarburantService(CarburantRepository carburantRepository) {
        this.carburantRepository = carburantRepository;
    }
   

    public List<Carburant> select(){
        return this.carburantRepository.findAll();
    }

    public Carburant Creer(Carburant carburant){
        return carburantRepository.save(carburant);
    }

    public Carburant update(int idCarburant,Carburant modifier){
        return this.carburantRepository.findById(idCarburant).map(
            carburant ->{
                // carburant.setIdCarburant(modifier.getIdCarburant());
                carburant.setNomCarburant(modifier.getNomCarburant());
                carburant.setEtat(modifier.getEtat());
                return carburantRepository.save(carburant);
            }
        ).orElseThrow(() -> new RuntimeException("carburant pas trouver"));
    }

    public Carburant deleteCarburant(int idCarburant,Carburant modifier){
        return this.carburantRepository.findById(idCarburant).map(
            carburant ->{
                // carburant.setIdCarburant(modifier.getIdCarburant());
                carburant.setNomCarburant(modifier.getNomCarburant());
                carburant.setEtat(modifier.getEtat());
                return carburantRepository.save(carburant);
            }
        ).orElseThrow(() -> new RuntimeException("carburant pas trouver"));
    }

}

