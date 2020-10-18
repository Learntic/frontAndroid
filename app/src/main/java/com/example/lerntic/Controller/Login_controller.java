package com.example.lerntic.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.login;
import com.example.lerntic.View.MainActivity;
import com.example.lerntic.View.OwnCourses;


public class Login_controller {
    public login login;
    public user User = new user();

    public Login_controller() { }

    public user SignIn(String user, String pass, Context context) {
       User = new user(user,"",pass);
       login = new login(User,context);
       User = login.getUser();
       System.out.println(User.getUsername());
       while(User.getUsername()==null){
           System.out.println(User.getUsername());
           User = login.getUser();
       }
       return User;
    }

}
