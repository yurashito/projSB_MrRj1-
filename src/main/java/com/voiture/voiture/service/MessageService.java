package com.voiture.voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getAllDocuments() {
        return repository.findAll();
    }

    public void insertTestDocument(Message mess) {
        Message testDocument = new Message();
        testDocument.setIdSend(mess.getIdSend());
        testDocument.setIdReceive(mess.getIdReceive());
        // Initialisez les autres champs si nécessaire
        repository.save(testDocument);
    }
}