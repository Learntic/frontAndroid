package com.example.lerntic.Controller;

import com.example.lerntic.Model.Actualizar;
import com.example.lerntic.Model.Objects.user;

public class Actualizar_controller {

    public Actualizar actualizar;
    public user u = new user();

    public Actualizar_controller(){}

    public user actualizar(String id, String token){
        u = new user("", token, "", id);
        actualizar = new Actualizar(u);
        u = actualizar.getUser();
        while(u.getUsername()==null){
            u = actualizar.getUser();
        }
        return u;
    }
}
