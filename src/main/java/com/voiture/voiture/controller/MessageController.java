package com.voiture.voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voiture.voiture.modele.Message;
import com.voiture.voiture.service.JwtTokenUtil;
import com.voiture.voiture.service.MessageService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;
    private final JwtTokenUtil jwtTokenUtil;


    @Autowired
    public MessageController(MessageService messageService , JwtTokenUtil jwtTokenUtil) {
        this.messageService = messageService;
        this.jwtTokenUtil= jwtTokenUtil;
    }

    @GetMapping("/select")
    public List<Message> getAllDocuments() {
        return messageService.getAllDocuments();
    }

    // @PostMapping("/envoyerMessage")
    // public void EnvoyerMessage(@RequestBody Message mess) {
    //     messageService.EnvoyerMessage(mess);
    // }

    @PostMapping("/envoyerMessage")
    public ResponseEntity<Object> EnvoyerMessage(javax.servlet.http.HttpServletRequest request , @RequestBody Message mess) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        System.out.println("le idUtilisateur est : "+Integer.parseInt(claims.getBody().getSubject()));
                        String idUtilisateur = claims.getBody().getSubject();
                        mess.setIdSend(Integer.parseInt(idUtilisateur));
                        messageService.EnvoyerMessage(mess);
                        return ResponseEntity.ok("message envoyer avec succes !");
                    }else{
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                            Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Une erreur s'est produite : le token n'est plus valide",
                                "timestamp", System.currentTimeMillis()
                            )
                        );
                    } 
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "message", "Une erreur s'est produite : desole , vous n'avez pas l'authorisation",
                    "timestamp", System.currentTimeMillis()
                )
            );
        }
    }


    @GetMapping("/MessageParUtilisateur11/{idPersonne}")
    public List<Message> MessageParUtilisateur(@PathVariable int idPersonne) {
        return messageService.MessageParUtilisateur(idPersonne);
    }

    // @GetMapping("/MessageParUtilisateur/{idPersonne}")
    // public List<Message> MessageParUtilisateur(@PathVariable int idPersonne) {
    //     return messageService.MessageParUtilisateur(idPersonne);
    // }
    
    @GetMapping("/MessageParUtilisateur")
    public ResponseEntity<Object> MessageParUtilisateur1(javax.servlet.http.HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        System.out.println("le idUtilisateur est : "+Integer.parseInt(claims.getBody().getSubject()));
                        String idUtilisateur = claims.getBody().getSubject();
                        int idPersonne= Integer.parseInt(idUtilisateur);
                        return ResponseEntity.ok(messageService.MessageParUtilisateur(idPersonne));
                    }else{
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                            Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Une erreur s'est produite : le token n'est plus valide",
                                "timestamp", System.currentTimeMillis()
                            )
                        );
                    } 
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "message", "Une erreur s'est produite : vous n'avez pas l'authorisation desole",
                    "timestamp", System.currentTimeMillis()
                )
            );
        }
    }

    // @GetMapping("/MessageDUnePersonne/{idSend}/{idReceive}")
    // public List<Message> MessageParPersonne1(@PathVariable int idSend,@PathVariable int idReceive) {
    //     return messageService.MessageParPersonne(idSend,idReceive);
    // }

    @GetMapping("/MessageDUnePersonne")
    public ResponseEntity<Object> MessageParPersonne(javax.servlet.http.HttpServletRequest request , @RequestParam int idReceive) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
                
                    if(jwtTokenUtil.isTokenValid(bearerToken)){
                        Jws<Claims> claims = jwtTokenUtil.decomposeLeToken(bearerToken);
                        System.out.println("le idUtilisateur est : "+Integer.parseInt(claims.getBody().getSubject()));
                        String idUtilisateur = claims.getBody().getSubject();
                        int idPersonne= Integer.parseInt(idUtilisateur);
                        return ResponseEntity.ok(messageService.MessageParPersonne(idPersonne , idReceive ));
                    }else{
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                            Map.of(
                                "status", HttpStatus.BAD_REQUEST.value(),
                                "message", "Une erreur s'est produite : le token n'est plus valide",
                                "timestamp", System.currentTimeMillis()
                            )
                        );
                    } 
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                    "status", HttpStatus.BAD_REQUEST.value(),
                    "message", "Une erreur s'est produite : vous n'avez pas l'authorisation desole",
                    "timestamp", System.currentTimeMillis()
                )
            );
        }

        // return messageService.MessageParPersonne(idSend,idReceive);
    }
}



