package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Actualizar;
import com.example.lerntic.Model.Consultar;
import com.example.lerntic.Model.Objects.user;

public class UserData_controller {

    public Actualizar actualizar;
    public Consultar consultar;
    public user User = new user();

    public UserData_controller(){}

    public user actualizar(user user, Context context){
        this.User = user;
        actualizar = new Actualizar(User, context);
        User = actualizar.getUser();
        while(User.getUsername()==null){
            User = actualizar.getUser();
        }
        return User;
    }

    public user getData(String username, String uid, String token, Context context){
        User = new user(username, token, "", uid);
        consultar = new Consultar(User,context);
        User = consultar.getUser();
        while(User.getUsername() == null){
            User = consultar.getUser();
        }
        System.out.println(User.getName());
        System.out.println(User.getAge());
        System.out.println(User.getEmail());
        return User;
    }
}
