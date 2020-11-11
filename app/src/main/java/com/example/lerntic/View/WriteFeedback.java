package com.example.lerntic.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.lerntic.Controller.WriteFeedback_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import androidx.appcompat.app.AppCompatActivity;

public class WriteFeedback extends AppCompatActivity {

    public EditText opinion = null;
    public EditText nota = null;
    public Button botonEnviar = null;
    public user User;
    public course Course;

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout people;
    public LinearLayout profile;
    //---------

    final private WriteFeedback_controller writeFeedback_controller = new WriteFeedback_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_feedback);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String id = getIntent().getStringExtra("Id");
        int course_id = getIntent().getIntExtra("course_id",0);
        String course_description = getIntent().getStringExtra("course_description");
        String course_name = getIntent().getStringExtra("course_name");
        double course_score = getIntent().getDoubleExtra("course_score",0);

        User = new user(username,token,"",id);
        Course = new course(course_id,course_description,course_name,course_score);
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

        opinion =  findViewById(R.id.et_opinionFeedback);
        nota = findViewById(R.id.et_notaFeedback);
        botonEnviar =  findViewById(R.id.btn_enviarFeedback);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedback f = new feedback(-1, User.getUsername(), Course.get_course_id(), opinion.getText().toString(), Float.parseFloat(nota.getText().toString()));
                writeFeedback_controller.writeFeedback(f,getApplicationContext(), User.getToken());
                Intent intent = new Intent(getApplicationContext(), Course_detail.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Id",User.getid());
                intent.putExtra("course_id", Course.get_course_id());
                intent.putExtra("course_description", Course.get_course_description());
                intent.putExtra("course_name", Course.get_name());
                intent.putExtra("course_score", Course.get_course_score());
                startActivity(intent);
                }
        });

    }


}
