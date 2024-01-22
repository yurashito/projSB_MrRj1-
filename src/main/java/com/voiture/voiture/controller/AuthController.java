package com.voiture.voiture.controller;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.voiture.voiture.service.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @PostMapping("/tout")
    public String obtenirToutesLesPersonnes() {
        return "Liste de toutes les personnes";
    }

 
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @GetMapping("/voirToken")
    public String votreEndpoint(javax.servlet.http.HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String bearerToken = authorizationHeader.substring(7); // Supprimer "Bearer " du début
            return  " est il est encore valide :  "+jwtTokenUtil.isTokenValid(bearerToken);
        } else {
            return "Bearer Token non trouvé";
        }
    }

  
    @PostMapping("/login")
    public String login() {
        
        // SecureRandom secureRandom = new SecureRandom();
        // byte[] key = new byte[32]; // 32 bytes = 256 bits
        // secureRandom.nextBytes(key);

        // // Convertir la clé en une chaîne hexadécimale (pour l'affichage ou le stockage)
        // StringBuilder keyStringBuilder = new StringBuilder();
        // for (byte b : key) {
        //     keyStringBuilder.append(String.format("%02x", b));
        // }
        String username= "fehizoro";
        String token = jwtTokenUtil.generateToken(username);

            return token;
        // return "token : " + token+" //----> cle : "+jwtTokenUtil.getSecret_Key()+"-----> token est il encore valide"+ jwtTokenUtil.isTokenValid(token);
    }


}
