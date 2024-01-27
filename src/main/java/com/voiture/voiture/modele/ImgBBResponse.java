package com.voiture.voiture.modele;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

// @NoArgsConstructor
public class ImgBBResponse {
   
    private ImgBBData data;
    private boolean success;
    private int status;

    
   



    public ImgBBResponse() {
    }


    public ImgBBResponse(ImgBBData data, boolean success, int status) {
        this.data = data;
        this.success = success;
        this.status = status;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


    

    public ImgBBResponse(ImgBBData data) {
        this.data = data;
    }

    public ImgBBData getData() {
        return data;
    }

    public void setData(ImgBBData data) {
        this.data = data;
    }

    

  

    
    
}