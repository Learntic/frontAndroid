package com.example.lerntic.Model;

import com.example.lerntic.Model.Objects.user;

public class login {
    public user user_return = new user();


    private user login(){
        user_return.setToken("token");
        user_return.setUsername("nombre");

        

        return user_return;
    }
}
