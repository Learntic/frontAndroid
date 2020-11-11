package com.example.lerntic.Model.Objects;

public class People {

    String username;
    String fullname;
    String uid;
    String error;

    public People(String username) {
        this.username = username;
    }

    public People(String username, String fullname, String uid, String error) {
        this.username = username;
        this.fullname = fullname;
        this.uid = uid;
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getUid() {
        return uid;
    }

    public String getError() {
        return error;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setError(String error) {
        this.error = error;
    }
}
