package com.example.lerntic.Model.Objects;

public class user {
    String username;
    String token;
    String password;

    public user (String username, String token, String password){
        this.username = username;
        this.token = token;
        this.password = password;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String password) {
        this.token = password;
    }
}
