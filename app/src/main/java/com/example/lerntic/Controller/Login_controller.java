package com.example.lerntic.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.login;
import com.example.lerntic.View.OwnCourses;


public class Login_controller {
    public login login = new login();
    public user User = new user();


    public Login_controller() {

    }

    public void Login_controller(String user, String pass, Context context) {
        User = new user(user,"",pass);
        User = (user) login.login(User);


        if (User.getToken()!="" && User.getUsername()!= "" ){
            next(context,User);
        }
        else{
            Toast.makeText(context,"Verifica los datos",Toast.LENGTH_LONG).show();
        }
    }
    private void next(Context context,user User){
        Intent intent = new Intent(context, OwnCourses.class);
        intent.putExtra("usuario", (Parcelable) User);
        context.startActivity(intent);

    }

}
