package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lerntic.Controller.Login_controller;
import com.example.lerntic.R;

import com.example.lerntic.Model.Objects.user;

public class MainActivity extends AppCompatActivity {

    public user User = new user();

    public EditText user = null;
    public EditText pass = null;

    public Button botonSingIn = null;
    public Button botonSingUp = null;

    private Login_controller controller_login = new Login_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usernameInput);
        pass = findViewById(R.id.passwordInput);
        botonSingIn =  findViewById(R.id.btn_ingresar);
        botonSingUp =  findViewById(R.id.btn_SignUp);

        botonSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* User = controller_login.SignIn(user.getText().toString(),pass.getText().toString(),getApplicationContext());
                System.out.println(User.getUsername());
                System.out.println(User.getToken());*/
                openOwnCourses();
            }
        });

        botonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openRegister();
            }
        });
    }

    public void openOwnCourses(){
        Intent intent = new Intent(this, OwnCourses.class);
        //intent.putExtra("Username",User.getUsername());
        //intent.putExtra("Token",User.getToken());
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}