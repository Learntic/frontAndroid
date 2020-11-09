package com.example.lerntic.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lerntic.Controller.UserData_controller;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import androidx.appcompat.app.AppCompatActivity;

public class ActualizarDatos extends AppCompatActivity {

    public user User = new user();
    public user UserData = new user();

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout people;
    public LinearLayout profile;
    //---------

    public EditText fullName = null;
    public EditText age = null;
    public EditText email = null;

    public Button botonActualizar = null;

    private final UserData_controller userData_controller = new UserData_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String id = getIntent().getStringExtra("Id");

        User = new user(username,token,"",id);
        UserData = new user(username,token,"",id);

        //----------Botton MENU
        home = findViewById(R.id.menu_home);
        courses = findViewById(R.id.menu_cours);
        people = findViewById(R.id.menu_friends);
        profile = findViewById(R.id.menu_profile);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OwnCourses.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllActivities.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PeopleView.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        //---------------------

        fullName = findViewById(R.id.user_data);
        age = findViewById(R.id.age_data);
        email = findViewById(R.id.email_data);
        botonActualizar =  findViewById(R.id.button_DoUpdate);

        UserData = userData_controller.getData(User.getUsername(),User.getid(),User.getToken(), getApplicationContext());

        fullName.setText(UserData.getName());
        age.setText(UserData.getAge());
        if (UserData.getEmail()==null){
            UserData.setEmail("-");
        }
        email.setText(UserData.getEmail());

        botonActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData.setUsername(User.getUsername());
                UserData.setid(User.getid());
                UserData.setToken(User.getToken());
                UserData.setName(fullName.getText().toString());
                UserData.setAge(Integer.parseInt(age.getText().toString()));
                UserData.setEmail(email.getText().toString());

                UserData = userData_controller.actualizar(UserData, getApplicationContext());

                if (UserData.getid().equals("-1")){
                    Toast.makeText(getApplicationContext(), "Error en la Actualizacion",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Actualizacion realizada correctamente",
                            Toast.LENGTH_SHORT).show();
                    fullName.setText(UserData.getName());
                    age.setText(UserData.getAge());
                    if (UserData.getEmail()==null){
                        UserData.setEmail("-");
                    }
                    email.setText(UserData.getEmail());
                }
            }
        });

    }

}
