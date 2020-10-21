package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.RegisterFunc;

public class Register_controller {
    public RegisterFunc registerFunc;
    public user User = new user();

    public Register_controller() { }

    public user signUp(String user, String pass, Context context){
        User = new user(user,"",pass,"");
        registerFunc = new RegisterFunc(User, context);
        User = registerFunc.getUser();
        while(User.getUsername()==null){
            User = registerFunc.getUser();
        }
        return User;
    }
}
