package com.example.kqsx2.Model;

public class JWTToken {
    private String idToken;

    JWTToken(String idToken) {
        this.idToken = idToken;
    }

    String getIdToken() {
        return idToken;
    }

    void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
