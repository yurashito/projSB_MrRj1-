package com.voiture.voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.voiture.voiture.modele.Annonce;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AnnonceDetailService {
    private final ImgBBService  ImgBBService;
    private final JdbcTemplate jdbcTemplate;
    private final AnnonceService  annonceService;
    private final ObjectMapper objectMapper;

    @Autowired
    public AnnonceDetailService(JdbcTemplate jdbcTemplate, AnnonceService  annonceService ,  ObjectMapper objectMapper ,  ImgBBService  ImgBBService) {
        this.jdbcTemplate = jdbcTemplate;
        this.annonceService= annonceService;
        this.objectMapper= objectMapper;
        this.ImgBBService= ImgBBService;
    }

    public Timestamp getDateActuelle(){
        LocalDateTime dateActuelle = LocalDateTime.now();
        Timestamp dateEnTimeStamp = Timestamp.valueOf(dateActuelle);
        return dateEnTimeStamp;
    }

    @Transactional
    public void insertionAnnonceAvecPhoto(Annonce Annonce , List<MultipartFile> listePhoto) throws Exception{
        Annonce annonceEnregiste = annonceService.Creer(Annonce);
        if(annonceEnregiste.getDateHeureAnnonce()==null){
            Timestamp dateActu = getDateActuelle();
            annonceEnregiste.setDateHeureAnnonce(dateActu);
        }
        if(annonceEnregiste.getPourcentageAlaina()==0){
            annonceEnregiste.setPourcentageAlaina(20);
        }
        for(MultipartFile file  : listePhoto   ){
            JsonNode jsonNode = objectMapper.readTree(this.ImgBBService.uploadImages(file));
            if (jsonNode.has("data")) {
                JsonNode dataNode = jsonNode.get("data");
                if (dataNode.has("display_url")) {
                    jdbcTemplate.update("insert into photoVoiture(idannonce , nomphoto) values(? ,?)" , annonceEnregiste.getAnnonce(), dataNode.get("display_url").asText());
                    System.out.println(dataNode.get("display_url").asText());
                }
            }
                
        }            
    }
}
