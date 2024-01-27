package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voiture.voiture.service.*;



import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/uploada")
public class UploadPhoto {
    private final ImgBBService  ImgBBService;
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    public UploadPhoto(ImgBBService  ImgBBService ){
        this.ImgBBService= ImgBBService;
    }

    @GetMapping
    public String testUpload(@RequestParam String response) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(this.ImgBBService.uploadLocalImage(response));

        if (jsonNode.has("data")) {
            JsonNode dataNode = jsonNode.get("data");
            if (dataNode.has("display_url")) {
                return dataNode.get("display_url").asText();
            }
        }
        throw new Exception("erreur de la recuperation du lien de l'image");
    }
    @GetMapping("/uneImage")
    public String testUpload2( @RequestParam("file") MultipartFile response) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(this.ImgBBService.uploadImages(response));

        if (jsonNode.has("data")) {
            JsonNode dataNode = jsonNode.get("data");
            if (dataNode.has("display_url")) {
                return dataNode.get("display_url").asText();
            }
        }
        throw new Exception("erreur de la recuperation du lien de l'image");
    }

    @PostMapping("/desImage")
    public String[] testUpload3( @RequestParam("files") List<MultipartFile> files) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        String[] resultat = new String[files.size()];
        int i=0;
        
        for(MultipartFile file  : files   ){
            JsonNode jsonNode = objectMapper.readTree(this.ImgBBService.uploadImages(file));
            if (jsonNode.has("data")) {
                JsonNode dataNode = jsonNode.get("data");
                if (dataNode.has("display_url")) {
                    resultat[i]=dataNode.get("display_url").asText() ;
                    System.out.println(dataNode.get("display_url").asText());
                }
            }
            i=i+1;    
        }
        
        return resultat;
    }

}
