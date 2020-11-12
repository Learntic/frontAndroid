package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Actualizar;
import com.example.lerntic.Model.Consultar;
import com.example.lerntic.Model.Objects.user;

public class UserData_controller {

    public Actualizar actualizar;
    public Consultar consultar;
    public user User = new user();
    boolean NotRecived = true;

    public UserData_controller(){}

    public user actualizar(user user, Context context){
        NotRecived = true;
        this.User = user;
        actualizar = new Actualizar(User, context);
        User = actualizar.getUser();
        while(NotRecived){
            User = actualizar.getUser();
            NotRecived = !actualizar.getRecibir();
            System.out.println(NotRecived);
        }
        System.out.println(User.getid());
        return User;
    }

    public user getData(String username, String uid, String token, Context context){
        NotRecived = true;
        User = new user(username, token, "", uid);
        consultar = new Consultar(User,context);
        User = consultar.getUser();
        while(NotRecived){
            User = consultar.getUser();
            NotRecived = !consultar.getRecived();
        }
        return User;
    }
}
