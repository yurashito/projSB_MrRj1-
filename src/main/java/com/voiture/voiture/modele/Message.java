package com.voiture.voiture.modele;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;;

@Document(collection = "message")
public class Message {
    @Id
    private String id;
    private int idSend;
    private int idReceive;
    private String message;
    private Date dateMessage;


    // Constructeurs, getters, setters, etc.


    @Override
    public String toString() {
        return "MonEntite{" +
                "id='" + id + '\'' +
                ", idSend=" + idSend +
                ", idReceive=" + idReceive +
                ", message=" + message +
                ", dateMessage=" + dateMessage +
                '}';
    }

    
    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return int return the idSend
     */
    public int getIdSend() {
        return idSend;
    }

    /**
     * @param idSend the idSend to set
     */
    public void setIdSend(int idSend) {
        this.idSend = idSend;
    }

    /**
     * @return int return the idReceive
     */
    public int getIdReceive() {
        return idReceive;
    }

    /**
     * @param idReceive the idReceive to set
     */
    public void setIdReceive(int idReceive) {
        this.idReceive = idReceive;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    
    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }


}