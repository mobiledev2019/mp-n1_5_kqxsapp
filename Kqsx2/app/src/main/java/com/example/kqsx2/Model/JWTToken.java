package com.example.kqsx2.Model;

public class JWTToken {
    private String id_token;

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public JWTToken(String id_token) {
        this.id_token = id_token;
    }
}
