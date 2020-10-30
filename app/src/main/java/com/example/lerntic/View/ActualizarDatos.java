package com.example.lerntic.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lerntic.Controller.Actualizar_controller;
import com.example.lerntic.Controller.Login_controller;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import androidx.appcompat.app.AppCompatActivity;

public class ActualizarDatos extends AppCompatActivity {

    public user u = new user();

    public EditText userName = null;
    public EditText pass = null;
    public EditText fullName = null;
    public EditText age = null;
    public EditText email = null;

    public Button botonActualizar = null;

    private Actualizar_controller actualizar_controller = new Actualizar_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);
/*
        userName = findViewById(R.id.);
        pass = findViewById(R.id.);
        fullName = findViewById(R.id.);
        age = findViewById(R.id.);
        email = findViewById(R.id.);
        botonActualizar =  findViewById(R.id.);
*/
        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*u = actualizar_controller.actualizar(userName.getText().toString(),pass.getText().toString(),getApplicationContext());
                System.out.println("user After:"+User.getUsername());
                System.out.println("Token After:"+User.getToken());
                if (User.getid().equals("-1")){
                    System.out.println("-1");
                    Toast.makeText(getApplicationContext(), "Error en login",
                            Toast.LENGTH_SHORT).show();
                }else{
                    System.out.println("next");
                    openOwnCourses();
                }*/
            }
        });

    }

    public void openOwnCourses(){
        /*Intent intent = new Intent(this, OwnCourses.class);
        intent.putExtra("Username",User.getUsername());
        intent.putExtra("Token",User.getToken());
        intent.putExtra("Id",User.getid());
        startActivity(intent);*/
    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

}
