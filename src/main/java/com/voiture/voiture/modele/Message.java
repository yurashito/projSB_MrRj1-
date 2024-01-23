package com.voiture.voiture.modele;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Message {
    @Id
    private String id;

    private String idSend;
    private String idReceive;

    // Constructeurs, getters, setters, etc.


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
     * @return String return the idSend
     */
    public String getIdSend() {
        return idSend;
    }

    /**
     * @param idSend the idSend to set
     */
    public void setIdSend(String idSend) {
        this.idSend = idSend;
    }

    /**
     * @return String return the idReceive
     */
    public String getIdReceive() {
        return idReceive;
    }

    /**
     * @param idReceive the idReceive to set
     */
    public void setIdReceive(String idReceive) {
        this.idReceive = idReceive;
    }

}
