package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lerntic.Controller.Adapter_Courses;
import com.example.lerntic.Controller.Adapter_Feedback;
import com.example.lerntic.Controller.Adapter_temario;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;

public class course_detail_noreg extends AppCompatActivity {
    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout friends;
    public LinearLayout profile;
    //---------

    public user User;

    public TextView name;

    ArrayList<String> DataList;
    RecyclerView recycler,recycler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail_noreg);


        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String course = getIntent().getStringExtra("Course");

        User = new user(username,token,"","");
        name.setText(course);

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
                startActivity(intent);
            }
        });
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AllActivities.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                startActivity(intent);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), friends.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Profile.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                startActivity(intent);
            }
        });
        //---------------------


        recycler = findViewById(R.id.Recycler_Temario);
        recycler2 = findViewById(R.id.Recycler_FeedBack);

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataList = new ArrayList<String>();

        for (int i = 0; i<=50;i++){
            DataList.add("Amigo "+i);
        }

        final Adapter_temario adapter = new Adapter_temario(DataList);
        recycler.setAdapter(adapter);
        final Adapter_Feedback adapter2 = new Adapter_Feedback(DataList);
        recycler2.setAdapter(adapter);
    }
}