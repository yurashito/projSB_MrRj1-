package com.voiture.voiture.service;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MessageService(MessageRepository repository, MongoTemplate mongoTemplate) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<Message> getAllDocuments() {
        return repository.findAll();
    }

    public void EnvoyerMessage(Message mess) {
        Message testDocument = new Message();
        testDocument.setIdSend(mess.getIdSend());
        testDocument.setIdReceive(mess.getIdReceive());
        testDocument.setMessage(mess.getMessage());
        testDocument.setDateMessage(new Date(System.currentTimeMillis()));
        // Initialisez les autres champs si nécessaire
        repository.save(testDocument);
    }

    public List<Message> MessageParUtilisateur(int idPersonne) {
        Criteria criteria = new Criteria().orOperator(
            Criteria.where("idSend").is(idPersonne),
            Criteria.where("idReceive").is(idPersonne)
        );
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Message.class);
    }

}
