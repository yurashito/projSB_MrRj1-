package com.voiture.voiture.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.voiture.voiture.modele.Message;


public interface MessageRepository extends MongoRepository<Message, String> {
    
}