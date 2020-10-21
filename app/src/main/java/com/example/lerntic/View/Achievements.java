package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lerntic.Controller.Adapter_Courses;
import com.example.lerntic.Controller.Adapter_achievements;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;

public class Achievements extends AppCompatActivity {

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout friends;
    public LinearLayout profile;
    //---------

    public user User;

    ArrayList<String> DataList;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String id = getIntent().getStringExtra("Id");

        User = new user(username,token,"",id);

        //----------Botton MENU
        home = findViewById(R.id.menu_home);
        courses = findViewById(R.id.menu_cours);
        friends = findViewById(R.id.menu_friends);
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
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), friends.class);
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

        recycler = findViewById(R.id.Recycler_Achievements);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataList = new ArrayList<String>();

        for (int i = 0; i<=50;i++){
            DataList.add("Logro "+i);
        }

        Adapter_achievements adapter = new Adapter_achievements(DataList);
        recycler.setAdapter(adapter);
    }
}