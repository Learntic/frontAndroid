package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import org.jetbrains.annotations.NotNull;

import com.example.lerntic.Controller.Login_controller;
import com.example.lerntic.Model.ApolloConnector;
import com.example.lerntic.R;
import com.example.lerntic.SignInQuery;
import com.example.lerntic.type.AccountInput;

public class MainActivity extends AppCompatActivity {

    public EditText user = null;
    public EditText pass = null;

    public Button boton = null;

    private Login_controller controller_login = new Login_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usernameInput);
        pass = findViewById(R.id.passwordInput);
        boton =  findViewById(R.id.btn_SignIn);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller_login.Login_controller(user.getText().toString(),pass.getText().toString(),getApplicationContext());
            }
        });
    }
}