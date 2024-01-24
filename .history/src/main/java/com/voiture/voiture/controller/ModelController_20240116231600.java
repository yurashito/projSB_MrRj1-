package com.voiture.voiture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.service.*;
import com.voiture.voiture.modele.*;

@RestController
@CrossOrigin("http://localhost:8100")
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController( ModelService modelService){
        this.modelService= modelService;
    }

    @GetMapping
    public List<Model> selectAll() {
        return this.modelService.select();
    }

    @PostMapping("/create")
    public Model create(@RequestBody Model favorie){
        return modelService.Creer(favorie) ;
    }

     @PostMapping("/updateModel/{idModel}")
    public Model updateModel(@PathVariable int idModel,@RequestBody Model modifier){
        return this.modelService.update(idModel, modifier);
    }
    @PostMapping("/deleteModel/{idModel}")
    public void deleteModel(@PathVariable int idModel){
         this.modelService.deleteModel(idModel);
    }
}
