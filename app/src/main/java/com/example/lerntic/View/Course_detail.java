package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lerntic.Controller.Adapter_Feedback;
import com.example.lerntic.Controller.Adapter_temario;
import com.example.lerntic.Controller.Feedback_controller;
import com.example.lerntic.Controller.Temario_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.temario;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;

public class Course_detail extends AppCompatActivity {

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout people;
    public LinearLayout profile;
    //---------

    public user User;
    public course Course;
    public Button feedbackB;
    public Button evaluacionB;
    public TextView name;

    ArrayList<temario> DataListTem;
    ArrayList<feedback> DataListFeed;
    RecyclerView recycler,recycler2;

    private final Feedback_controller feedback_controller = new Feedback_controller();
    private final Temario_controller temario_controller = new Temario_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        final String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        String id = getIntent().getStringExtra("Id");
        int course_id = getIntent().getIntExtra("course_id",0);
        String course_description = getIntent().getStringExtra("course_description");
        String course_name = getIntent().getStringExtra("course_name");
        double course_score = getIntent().getDoubleExtra("course_score",0);

        User = new user(username,token,"",id);
        Course = new course(course_id,course_description,course_name,course_score);

        TextView textView = (TextView) findViewById(R.id.txt_name_courseIns_detail);
        textView.setText(String.format("Curso: %s", Course.get_name()));

        //----------Botton MENU
        home = findViewById(R.id.menu_home);
        courses = findViewById(R.id.menu_cours);
        people = findViewById(R.id.menu_friends);
        profile = findViewById(R.id.menu_profile);
        feedbackB =  findViewById(R.id.btn_feedback);
        evaluacionB =  findViewById(R.id.btn_evaluacion);

        feedbackB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WriteFeedback.class);
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
        evaluacionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Game.class);
                String userToSend = "";
                if (Course.get_course_id()==1){
                    userToSend = User.getUsername()+" internet";
                }else{
                    userToSend = User.getUsername()+" apps";
                }
                System.out.println("USER TO SEND "+userToSend);
                intent.putExtra("Username",userToSend);
                startActivity(intent);
            }
        });

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

        recycler = findViewById(R.id.Recycler_TemarioInscrito);
        recycler2 = findViewById(R.id.Recycler_FeedBackInscito);

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataListTem = temario_controller.ShowTopics(Course.get_course_id(),getApplicationContext());
        DataListFeed =  feedback_controller.ShowFeedback(Course.get_course_id(),getApplicationContext());

        final Adapter_temario adapter = new Adapter_temario(DataListTem);
        recycler.setAdapter(adapter);
        final Adapter_Feedback adapter2 = new Adapter_Feedback(DataListFeed);
        recycler2.setAdapter(adapter2);
    }
}