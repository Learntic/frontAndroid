package com.example.lerntic.Model.Objects;

public class user {
    String username;
    String token;

    public user (String username, String token){
        this.username = username;
        this.token = token;
    }
    public user (){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return token;
    }

    public void setToken(String password) {
        this.token = password;
    }
}
