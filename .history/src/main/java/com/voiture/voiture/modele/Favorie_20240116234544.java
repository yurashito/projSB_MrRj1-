package com.voiture.voiture.modele;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity                 //pour que la class puisse etre mapper a une table
@Table(name = "favorie")
@Getter
@Setter
@NoArgsConstructor       //Pas obli t@ nandramako mba hampandeh azy
public class Favorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idfavorie;
    @Column
    int idannonce;
    @Column
    int idutilisateur;
    @Column
    int idutilisateur;
}
