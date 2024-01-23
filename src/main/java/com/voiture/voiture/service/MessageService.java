package com.voiture.voiture.service;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        testDocument.setDateMessage( new Date());
        repository.save(testDocument);
    }

    public List<Message> MessageParUtilisateur(int idPersonne) {
        Criteria criteria = new Criteria().orOperator(
            Criteria.where("idSend").is(idPersonne),
            Criteria.where("idReceive").is(idPersonne)
        );
        Query query = new Query(criteria);
        List<Message> messages = mongoTemplate.find(query, Message.class);
        
        // Ajouter des journaux de débogage
        // System.out.println("Query: " + query);
        // System.out.println("Nombre de messages trouvés: " + messages.size());
        // for(int i = 0 ; i< messages.size() ; i++){
        //     System.out.println(messages.get(i).getMessage());
        // }
    
        return messages;
    }
    

}
