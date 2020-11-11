package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

public class Profile extends AppCompatActivity {

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout people;
    public LinearLayout profile;
    //---------

    public user User;

    public CardView Ownfriends;
    public CardView Ownachievements;
    public CardView OwnData;
    public CardView CloseSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String id = getIntent().getStringExtra("Id");

        User = new user(username,token,"",id);

        //----------Botton MENU
        home = findViewById(R.id.menu_home);
        courses = findViewById(R.id.menu_cours);
        people = findViewById(R.id.menu_friends);
        profile = findViewById(R.id.menu_profile);
        home.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OwnCourses.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        courses.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllActivities.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        people.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PeopleView.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new OnClickListener() {
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

        Ownfriends = findViewById(R.id.button_ownFriends);
        Ownachievements= findViewById(R.id.botton_achievements);
        CloseSession = findViewById(R.id.button_close_session);
        OwnData = findViewById(R.id.botton_update);

        Ownfriends.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), friends.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        Ownachievements.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Achievements.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });
        CloseSession.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        OwnData.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActualizarDatos.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                startActivity(intent);
            }
        });

    }
}