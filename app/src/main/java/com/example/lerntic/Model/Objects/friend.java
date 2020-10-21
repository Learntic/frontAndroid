package com.example.lerntic.Model.Objects;

public class friend {

    String fullname;
    String username;
    int age;
    String error;

    public friend(String fullname, String username, int age, String error) {
        this.fullname = fullname;
        this.username = username;
        this.age = age;
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getfullname() {
        return fullname;
    }

    public void setfullname(String fullname) {
        this.fullname = fullname;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    public String geterror() {
        return error;
    }

    public void seterror(String error) {
        this.error = error;
    }
}
