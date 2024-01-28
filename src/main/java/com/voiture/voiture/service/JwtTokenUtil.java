package com.voiture.voiture.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.voiture.voiture.modele.Utilisateur;

import java.security.Key;
// import java.util.Date;
import java.security.SecureRandom;
import java.util.*;

@Service
public class JwtTokenUtil {

    private static final long DureeExpiration = 400000000;
    private  String SECRET_KEY = "53857461b5aed814690f37dbd1c689c669e02b519fe61920459334137519f076";

    public void setSecret_Key(String secret){
        this.SECRET_KEY= secret;
    }
    public String getSecret_Key(){
       return this.SECRET_KEY;
    }
    public JwtTokenUtil(String key){
        this.SECRET_KEY= key;
    }
    public JwtTokenUtil(){}

    public String generateToken(String username) {
        Key key1 = new SecretKeySpec(this.SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Date now = new Date();
        Date dateExpiration = new Date(now.getTime()+DureeExpiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(key1)
                .compact();
    }

    public String generateToken(Utilisateur Utilisateur) {
        
        Key key1 = new SecretKeySpec(this.SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Date now = new Date();
        Date dateExpiration = new Date(now.getTime()+DureeExpiration);
        String idUtilisateur= String.valueOf(Utilisateur.getIdUtilisateur());
        String identifiant = String.valueOf(Utilisateur.getIdentifiant());
        System.out.println("idUtilisateur : "+idUtilisateur+" identifiant "+ identifiant);
        return Jwts.builder()
                .setSubject(idUtilisateur)
                .claim("identifiant", identifiant)
                .setIssuedAt(now)
                .setExpiration(dateExpiration)
                .signWith(key1)
                .compact();
    }

    public Jws<Claims> decomposeLeToken(String token){
        Key key1 = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key1)
                .build()
                .parseClaimsJws(token);
        return claims;
    }



    public boolean isTokenValid(String token) {
        try {
            Key key1 = new SecretKeySpec(SECRET_KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key1)
                    .build()
                    .parseClaimsJws(token);
            Date expirationDate = claims.getBody().getExpiration();            
            Date now = new Date();
            return !expirationDate.before(now);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
