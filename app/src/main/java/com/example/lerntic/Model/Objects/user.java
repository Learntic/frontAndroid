package com.example.lerntic.Model.Objects;

public class user {
    String username;
    String token;
    String password;
    String id;
    String name;
    int age;

    public user (String username, String token, String password, String id){
        this.username = username;
        this.token = token;
        this.password = password;
        this.id = id;
    }
    public user (){

    }

    public user(String username, String token, String password, String id, String name, int age) {
        this.username = username;
        this.token = token;
        this.password = password;
        this.id = id;
        this.name = name;
        this.age = age;
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

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
