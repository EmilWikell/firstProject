package com.example.firstproject;

import lombok.Data;

@Data
public class ResponseKompis {

    String message;
    Boolean status;

    public ResponseKompis(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
