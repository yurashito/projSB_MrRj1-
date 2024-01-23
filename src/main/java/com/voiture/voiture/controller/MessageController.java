package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/select")
    public List<Message> getAllDocuments() {
        return messageService.getAllDocuments();
    }

    @PostMapping("/envoyerMessage")
    public void EnvoyerMessage(@RequestBody Message mess) {
        messageService.EnvoyerMessage(mess);
    }

    @GetMapping("/MessageParUtilisateur/{idPersonne}")
    public List<Message> MessageParUtilisateur(@PathVariable int idPersonne) {
        return messageService.MessageParUtilisateur(idPersonne);
    }
}



