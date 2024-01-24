package com.voiture.voiture.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.voiture.voiture.modele.AnnonceDetail;
import com.voiture.voiture.modele.Utilisateur;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
@Repository
public class AnnonceDetailRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnnonceDetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private AnnonceDetail getLigneAnnonce(ResultSet resultSet) throws SQLException {
        AnnonceDetail annonce = new AnnonceDetail();
        annonce.setIdAnnonce(resultSet.getInt("idAnnonce"));
        annonce.setDescription(resultSet.getString("description"));
        annonce.setDateHeureAnnonce(resultSet.getTimestamp("dateHeureAnnonce"));
        annonce.setIdVoiture(resultSet.getInt("idVoiture"));        
        annonce.setImatricule(resultSet.getString("iMatricule"));
        annonce.setIdCouleur(resultSet.getInt("idCouleur"));
        annonce.setCouleur(resultSet.getString("couleur"));
        annonce.setIdCreateur(resultSet.getInt("idCreateur"));
        annonce.setNomCreateur(resultSet.getString("nomCreateur"));
        annonce.setIdLieu(resultSet.getInt("idLieu"));
        annonce.setNomLieu(resultSet.getString("nomLieu"));
        annonce.setAnnee(resultSet.getString("annee"));
        annonce.setPrix(resultSet.getDouble("prix"));
        annonce.setPourcentageAlaina(resultSet.getDouble("pourcentageAlaina"));
        annonce.setEtatAnnonce(resultSet.getInt("etatAnnonce"));
        return annonce;
    }

    public void existencePrixMin(String prixMin , List<String> tableauRequette){
        if(prixMin.equals("")==false){
            double prix= Double.parseDouble(prixMin);
            if(prix >=0){
                String requette ="prix >="+prix;
                System.out.println(requette);

                tableauRequette.add(requette); 
            }
        }else{
            
            String requette ="prix >= 0";
            System.out.println(requette);

            tableauRequette.add(requette); 
        }
    }

    public void existencePrixMax(String prixMax , List<String> tableauRequette){
        if(prixMax.equals("")==false){
            double prix= Double.parseDouble(prixMax);
            if(prix >=0){
                String requette ="prix >="+prix;
                System.out.println(requette);
                tableauRequette.add(requette); 
            }
        }
    }

    public void existenceIdBoitedevitesse(String  idBoitedevitesse , List<String> tableauRequette){
        if(idBoitedevitesse.equals("")==false){
            int id= Integer.parseInt(idBoitedevitesse);
            if(id>=1){
                String requette ="idBoitedevitesse ="+id;
                System.out.println(requette);
                tableauRequette.add(requette);
            }
        }
    }
    

    public void existenceIdCarburant(String  idCarburant , List<String> tableauRequette){
        if(idCarburant.equals("")==false){
            int id= Integer.parseInt(idCarburant);
                if(id>=1){
                String requette ="idCarburant ="+id+" ";
                tableauRequette.add(requette);
            }
        }
    }

    public void existenceIdCategorie(String  idCategorie , List<String> tableauRequette){
        if(idCategorie.equals("")==false){
            int id= Integer.parseInt(idCategorie);
            if(id>=1){
                String requette ="idCategorie ="+id+" ";
                System.out.println(requette);
                tableauRequette.add(requette);
            }
        }
    }

    public void existenceIdLieu(String  idLieu , List<String> tableauRequette){
        if(idLieu.equals("")==false){
            int id= Integer.parseInt(idLieu);
            if(id>=1){
                String requette ="idLieu ="+id+" ";
                tableauRequette.add(requette);
            }
        }
    }

    public void existenceIdMarque(String  idMarque , List<String> tableauRequette){
        if(idMarque.equals("")==false){
            int id= Integer.parseInt(idMarque);
            if(id>=1){
                String requette ="idMarque ="+id+" ";
                tableauRequette.add(requette);
            }
        }
    }

    public void existenceIdModel(String  idModel , List<String> tableauRequette){
        if(idModel.equals("")==false){
            int id= Integer.parseInt(idModel);
            if(id>=1){
                String requette ="idModel ="+id+" ";
                tableauRequette.add(requette);
            }
        }
    }

    public List<String> listeContrainte(String prixMin ,  String prixMax , String idBoitedevitesse ,  String idCarburant ,  String idCategorie ,  String idLieu ,  String idMarque  ,  String idModel){
        List<String> tableauRequette= new ArrayList<>();
        existencePrixMin( prixMin , tableauRequette);
        existencePrixMax( prixMax ,  tableauRequette);
        existenceIdBoitedevitesse(  idBoitedevitesse ,  tableauRequette);
        existenceIdCarburant(  idCarburant ,  tableauRequette);
        existenceIdCategorie(  idCategorie ,  tableauRequette);
        existenceIdLieu(  idLieu ,  tableauRequette);
        existenceIdMarque(  idMarque ,  tableauRequette);
        existenceIdModel(  idModel ,  tableauRequette);
        return tableauRequette;
    }

    public String contrainteEnString(List<String> listeContrainte){
        String resultat= new String();
        int nombreContrainte=listeContrainte.size();
        for(int i=0 ; i<nombreContrainte ; i++){
            if(i==nombreContrainte-1){
                resultat= resultat+" "+listeContrainte.get(i);
            }else{
                resultat= resultat+" "+listeContrainte.get(i)+" and ";
            }
        }
        return resultat;

    }


    


    public List<AnnonceDetail> rechercheAnnonce(  String prixMin ,  String prixMax , String idBoitedevitesse ,  String idCarburant ,  String idCategorie ,  String idLieu ,  String idMarque  ,  String idModel ){
        List<String> listeConstrainte =  listeContrainte(  prixMin ,   prixMax ,  idBoitedevitesse ,  idCarburant ,   idCategorie ,   idLieu ,   idMarque  ,   idModel);
        String contrainte= contrainteEnString(listeConstrainte);
        
        String sql = "SELECT * FROM V_Annonce where "+contrainte;

        System.out.println(sql);
        List<AnnonceDetail> result = new ArrayList<>();
        jdbcTemplate.execute((Connection connection) -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    AnnonceDetail annonce =getLigneAnnonce(resultSet);
                  
                    result.add(annonce);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erreur lors de l'exécution de la requête de recherche dans annonceDetail", e);
            }

            return null; 
        });

        return result;

    }

    public List<AnnonceDetail> selectAll() {
        String sql = "SELECT * FROM V_Annonce";
        List<AnnonceDetail> result = new ArrayList<>();
        jdbcTemplate.execute((Connection connection) -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    AnnonceDetail annonce =getLigneAnnonce(resultSet);
                  
                    result.add(annonce);
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erreur lors de l'exécution de la requête SELECT dans annonceDetail", e);
            }

            return null; 
        });

        return result;

    } 
    public AnnonceDetailRepository  historiqueAnnonceUtilisateur() {
    
        @Query(value = "select * from annonce where :idCreateur = idCreateur " , nativeQuery = true)
        Utilisateur historiqueAnnonceUtilisateur(@Param("idCreateur") int idCreateur); 
    
}
}
