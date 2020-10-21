package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lerntic.Controller.Adapter_Courses;
import com.example.lerntic.Controller.AllOtherCourses_controller;
import com.example.lerntic.Controller.UserCourses_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;
import java.util.Arrays;

public class AllActivities extends AppCompatActivity {

    public user User;

    ArrayList<course> DataList;
    RecyclerView recycler;

    private AllOtherCourses_controller allOtherCourses_controller = new AllOtherCourses_controller();


    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout friends;
    public LinearLayout profile;
    //---------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_activities);

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

        recycler = findViewById(R.id.Recycler_AllCourses);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataList = allOtherCourses_controller.ShowCourses(username,token,getApplicationContext());

        final Adapter_Courses adapter = new Adapter_Courses(DataList, User);
        recycler.setAdapter(adapter);

        adapter.SetOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), course_detail_noreg.class);
                intent.putExtra("Username", User.getUsername());
                intent.putExtra("Token", User.getToken());
                intent.putExtra("Id",User.getid());
                intent.putExtra("course_id", DataList.get(recycler.getChildAdapterPosition(v)).get_course_id());
                intent.putExtra("course_description", DataList.get(recycler.getChildAdapterPosition(v)).get_course_description());
                intent.putExtra("course_name", DataList.get(recycler.getChildAdapterPosition(v)).get_name());
                intent.putExtra("course_score", DataList.get(recycler.getChildAdapterPosition(v)).get_course_score());
                v.getContext().startActivity(intent);
            }
        });
    }
}