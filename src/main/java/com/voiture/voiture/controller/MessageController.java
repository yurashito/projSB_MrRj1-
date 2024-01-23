package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/get-all-documents")
    public List<Message> getAllDocuments() {
        return messageService.getAllDocuments();
    }

    @PostMapping("/insert-test-document")
    public void insertTestDocument(@RequestBody Message mess) {
        messageService.insertTestDocument(mess);
    }
}

