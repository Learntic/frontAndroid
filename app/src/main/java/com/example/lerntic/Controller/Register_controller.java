package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.RegisterFunc;

public class Register_controller {
    public RegisterFunc registerFunc;
    public user User;

    public Register_controller() { }

    public user signUp(String user, String pass, String name, int age, Context context){
        User = new user(user,"",pass,"",name,age);
        registerFunc = new RegisterFunc(User, context);
        User = registerFunc.getUser();
        while(User.getid() == null)
        {
            User = registerFunc.getUser();
        }
        return User;
    }
}
