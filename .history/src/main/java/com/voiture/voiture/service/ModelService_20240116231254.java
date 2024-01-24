package com.voiture.voiture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.repository.*;
import com.voiture.voiture.modele.*;

@Service
public class ModelService {
    private final ModelRepository ModelRepository;

    @Autowired
    public ModelService(ModelRepository ModelRepository) {
        this.ModelRepository = ModelRepository;
    }

    public List<Model> select(){
        return this.ModelRepository.findAll();
    }

    public Model Creer(Model favorie){
        return ModelRepository.save(favorie);
    }

    public Model update(int idModel,Model modifier){
        return this.ModelRepository.findById(idModel).map(
            model ->{
                 model.setIdModel(modifier.getIdModel());
                model.setNomModel(modifier.getNomModel());
                model.setEtat(modifier.getEtat());
                return MarqueRepository.save(model);
            }
        ).orElseThrow(() -> new RuntimeException("model pas trouver"));
    }
    
    public Model deleteModel(int idModel){
        return this.ModelRepository.findById(idModel).map(
            model ->{
                model.setEtat(0);
                return ModelRepository.save(model);
            }
        ).orElseThrow(() -> new RuntimeException("model pas trouver"));
    }
}
