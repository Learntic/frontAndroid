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

    public EditText user, password, pasConfirm, userName, userAge;
    public Button boton;

    private final Register_controller register_controller = new Register_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.user_data);
        userName = findViewById(R.id.name);
        userAge =(EditText) findViewById(R.id.age);
        password = findViewById(R.id.age_data);
        pasConfirm = findViewById(R.id.confPas);
        boton = findViewById(R.id.button_DoUpdate);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().equals(pasConfirm.getText().toString())){
                    User = register_controller.signUp(user.getText().toString(),
                            password.getText().toString(),userName.getText().toString(),Integer.parseInt(userAge.getText().toString()),getApplicationContext());
                    if (User.getid().equals("-1")){
                        Toast.makeText(getApplicationContext(), "Error en Registro",
                                Toast.LENGTH_SHORT).show();
                    }else{
                        openOwnCourses();
                    }
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
        intent.putExtra("Id",User.getid());
        startActivity(intent);
    }
}