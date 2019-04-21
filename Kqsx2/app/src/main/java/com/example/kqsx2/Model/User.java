package com.example.kqsx2.Model;

public class User {
    private String password;
    private String username;
    private Boolean rememberMe;

    public User(String password, String username, Boolean rememberMe) {
        this.password = password;
        this.username = username;
        this.rememberMe = rememberMe;
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
