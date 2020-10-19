package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lerntic.Controller.Register_controller;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

public class Register extends AppCompatActivity {

    public com.example.lerntic.Model.Objects.user User = new user();

    public EditText user, password, pasConfirm;
    public Button boton;

    private Register_controller register_controller = new Register_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        pasConfirm = findViewById(R.id.pass);
        boton = findViewById(R.id.btn_SignIn);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.equals(pasConfirm)){
                    User = register_controller.signUp(user.getText().toString(),
                            password.getText().toString(),getApplicationContext());
                    openOwnCourses();
                }
                else
                    Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openOwnCourses(){
        Intent intent = new Intent(this, OwnCourses.class);
        intent.putExtra("Username",User.getUsername());
        intent.putExtra("Token",User.getToken());
        startActivity(intent);
    }
}