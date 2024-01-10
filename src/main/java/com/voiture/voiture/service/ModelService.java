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
}
