package com.example.lerntic.Controller;

import android.content.Context;


import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.login;


public class Login_controller {
    public login login;
    public user User = new user();


    public Login_controller() { }

    public user SignIn(String user, String pass, Context context) {
       User = new user(user,"",pass);
       login = new login(User);
       User = login.getUser();
       while(User.getUsername()==null){
           User = login.getUser();
       }
       return User;

    }

}
