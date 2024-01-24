drop database ventevoiture;
create database ventevoiture;
\c ventevoiture;

create table utilisateur(
    idUtilisateur serial not null primary key,
    nomUtilisateur varchar(100),
    prenomUtilisateur varchar(100),
    mail varchar(100),	
    numero varchar(25)	,
    mdp varchar(100),
    identifiant int default 0
);

insert into utilisateur(nomutilisateur,prenomutilisateur,mail,numero,mdp) values
    ('Diary', 'Razafinjatovo' , 'DiaryRazafinjatovo@gmail.com','0341010000','0000');
insert into utilisateur(nomutilisateur,prenomutilisateur,mail,numero,mdp) values
    ('Fehizoro', 'Rampanjato' , 'FehizoroRampanjato@gmail.com','0341000000','0000');
insert into utilisateur(nomutilisateur,prenomutilisateur,mail,numero,mdp) values
    ('Stephane', 'Ramiandrisoa' , 'StephaneRamiandrisoa@gmail.com','0341000000','0000');
insert into utilisateur(nomutilisateur,prenomutilisateur,mail,numero,mdp) values
    ('Jaona', 'Ratefy' , 'JaonaRatefy@gmail.com','0341000000','0000');
insert into utilisateur(nomutilisateur,prenomutilisateur,mail,numero,mdp,identifiant) values
    ('admin', 'admin' , 'admin@gmail.com','0341000000','0000',1);

-- ------------Any @ Fehizoro fa juste anaovako foreign key fotsiny
create table categorie(
    idCategorie serial primary key ,
    nomCategorie varchar(50),
    etat int default 1 
);	

insert into categorie(nomCategorie) values
('Mini-citadine'),
('petite voiture'),
('Voiture Compact'),
('Grosse Voiture'),
('Voiture des Prestige'),
('Voiture de Luxe'),
('Suv'),
('Grande Voiture Familiale'),
('Voiture de Sport')
;

create table marque	(
    idMarque serial primary key ,
    nomMarque varchar(50),
    etat int default 1 
);
insert into marque(nomMarque) values 
('Aeura'),
('Alfa Romeo'),
('Aston Martin'),
('Astra'),
('Audi'),
('Bentley'),
('BMW'),
('Brilliance')
;

create table carburant(
    idCarburant serial primary key , 
    nomCarburant varchar(50),
    etat int default 1 
);	
insert into carburant (nomCarburant) values 
('Diese'),
('Hybride'),
('Essence')
;

create table model(
    idModel serial primary key,
    nomModel varchar(50),
    etat int default 1 
 );	
insert into model(nomModel) values
('1'),
('100'),
('1000'),
('100 Mx'),
('1007'),
('104'),
('106'),
('107'),
('11'),
('12')
;

create table lieu(
    idLieu serial primary key , 
    nomLieu varchar(50),
    etat int default 1
);	
insert into lieu (nomLieu) values
('Antananarivo'),
('Ambatondraka'),
('Moramanga'),
('Antsirabe'),
('Ambositra'),
('Fianarantsoa'),
('Mananjary'),
('Tulear')
;


create table boiteDeVitesse(    
    idBoiteDeVitesse serial primary key ,
    nomBoiteDeVitesse varchar(50),
    etat int default 1 
    
);	
insert into boiteDeVitesse (nomBoiteDeVitesse) values
('Automatique'),
('Manuelle')
;

create table couleur(
    idCouleur serial not null primary key,
    nomCouleur varchar(100)
);

insert into couleur(nomCouleur) values('rouge');
insert into couleur(nomCouleur) values('noir');
insert into couleur(nomCouleur) values('blanc');
insert into couleur(nomCouleur) values('vert');
insert into couleur(nomCouleur) values('bleu');

create table voiture(
    idVoiture serial not null primary key ,
    imatricule varchar(100),
    idCategorie int not null,
    idMarque int not null,
    idCarburant int not null,
    idModel int not null,
    idBoiteDeVitesse int not null,
    idCouleur int not null,
    foreign key(idCategorie) references categorie(idCategorie),
    foreign key(idMarque) references marque(idMarque),
    foreign key(idCarburant) references carburant(idCarburant),
    foreign key(idModel) references model(idModel),
    foreign key(idBoiteDeVitesse) references boiteDeVitesse(idBoiteDeVitesse),
    foreign key(idCouleur) references couleur(idCouleur)
);

insert into voiture(imatricule,idCategorie,idMarque,idCarburant,idModel,idBoiteDeVitesse,idcouleur) values
    ('TAA0011',1,1,3,1,1,3);
insert into voiture(imatricule,idCategorie,idMarque,idCarburant,idModel,idBoiteDeVitesse,idcouleur) values
    ('TAB0201',2,3,2,1,1,1);
insert into voiture(imatricule,idCategorie,idMarque,idCarburant,idModel,idBoiteDeVitesse,idcouleur) values
    ('TAM1001',8,8,1,2,2,4);


create table annonce(
    idAnnonce serial not null primary key,	
    dateHeureAnnonce timestamp default now(),	
    description varchar(200),
    idVoiture int not null,
    idCreateur int not null,
    idLieu int not null,	
    Annee double precision,		
    Prix double precision,
    PourcentageAlaina double precision,	
    EtatAnnonce	 int default 0,
    foreign key(idVoiture) references voiture(idVoiture),
    foreign key(idCreateur) references utilisateur(idUtilisateur),
    foreign key(idLieu) references lieu(idLieu)
);

insert into annonce(description,idVoiture,idCreateur,idLieu,Annee,Prix,PourcentageAlaina) values
    ('Une voiture de couleur rouge 4 portes idéale pour une famille' , 1 , 1, 1, 2024 , 4000000 ,20);

insert into annonce(description,idVoiture,idCreateur,idLieu,Annee,Prix,PourcentageAlaina) values
    ('Une voiture de couleur blanc 3 portes' , 2 , 2, 4, 2020 , 3500000 ,20);


insert into annonce(description,idVoiture,idCreateur,idLieu,Annee,Prix,PourcentageAlaina) values
    ('Une voiture de couleur blanc 3 portes' , 3 , 3, 2, 2010 , 3000000 ,20);

create table photoVoiture(
    idPhotoVoiture serial not null primary key,
    idAnnonce int not null,
    nomPhoto varchar(150),
    foreign key(idAnnonce) references annonce(idAnnonce)
);

create table favorie(
    idFavorie serial not null primary key,
    idAnnonce int not null,
    idUtilisateur int not null,
    foreign key(idAnnonce) references annonce(idAnnonce),
    foreign key(idUtilisateur) references utilisateur(idUtilisateur)
);

insert into favorie(idAnnonce,idUtilisateur) values (1,2);
insert into favorie(idAnnonce,idUtilisateur) values (2,3);
insert into favorie(idAnnonce,idUtilisateur) values (3,4);

create table historiqueVente(
    idHistoriqueVente serial not null primary key,
    dateHeureVente timestamp default now(),
    idAnnonce int not null,
    idClient int not null,
    foreign key(idAnnonce) references annonce(idAnnonce),
    foreign key(idClient) references utilisateur(idUtilisateur)
);

create table notification(
    idNotification serial not null primary key,
    dateHeureNotification timestamp,
    idEnvoyeur int not null,
    idReceveur int not null,
    titre varchar(50),
    text varchar(100),
    foreign key(idEnvoyeur) references utilisateur(idUtilisateur),
    foreign key(idReceveur) references utilisateur(idUtilisateur)
);

-- possible mongodb'----------
create table message(
    idMessage serial not null primary key,
    dateHeureMessage timestamp default now(),
    idEnvoyeur int not null,
    idReceveur int not null,
    text varchar(200),
    foreign key(idEnvoyeur) references utilisateur(idUtilisateur),
    foreign key(idReceveur) references utilisateur(idUtilisateur)
);
-- --------------------------

create table commentaire(
    idCommentaire serial not null primary key,
    idAnnonce int not null,
    idUtilisateur int not null,
    text varchar(200),
    foreign key(idAnnonce) references annonce(idAnnonce),
    foreign key(idUtilisateur) references utilisateur(idUtilisateur)
);

create or replace view V_Annonce as(
    select idAnnonce,description,dateheureannonce , voiture.idVoiture , voiture.imatricule as imatricule , voiture.idCouleur as idCouleur , couleur.nomCouleur as couleur, 
    annonce.idCreateur as idCreateur , utilisateur.nomUtilisateur as nomCreateur , lieu.idLieu as idLieu , lieu.nomLieu as nomLieu,
    Annee,Prix , PourcentageAlaina EtatAnnonce 
    from annonce
    join Voiture
    on Voiture.idVoiture = annonce.idVoiture
    join utilisateur
    on utilisateur.idUtilisateur = annonce.idCreateur
    join lieu
    on lieu.idLieu = annonce.idLieu
    join couleur
    on couleur.idCouleur = voiture.idCouleur
); 

<!--  Manampy etat amin'n
ALTER TABLE ma_table
ADD COLUMN etat integer;