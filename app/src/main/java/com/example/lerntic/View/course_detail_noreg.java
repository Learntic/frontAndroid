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
import com.example.lerntic.Controller.UserCourses_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.inscription;
import com.example.lerntic.Model.Objects.temario;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;

public class course_detail_noreg extends AppCompatActivity {
    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout people;
    public LinearLayout profile;
    //---------

    public Button inscripcion;

    public user User;
    public course Course;

    public boolean Inscription;

    ArrayList<temario> DataListTem;
    ArrayList<feedback> DataListFeed;
    RecyclerView recycler,recycler2;

    private final Feedback_controller feedback_controller = new Feedback_controller();
    private final Temario_controller temario_controller = new Temario_controller();
    private final UserCourses_controller userCourses_controller = new UserCourses_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail_noreg);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");
        int course_id = getIntent().getIntExtra("course_id",0);
        String course_description = getIntent().getStringExtra("course_description");
        String course_name = getIntent().getStringExtra("course_name");
        double course_score = getIntent().getDoubleExtra("course_score",0);
        String id = getIntent().getStringExtra("Id");

        Course = new course(course_id,course_description,course_name,course_score);

        User = new user(username,token,"",id);

        TextView textView = (TextView) findViewById(R.id.Own_courses_header);
        textView.setText(String.format("Curso: %s", Course.get_name()));

        //----------Botton MENU
        home = findViewById(R.id.menu_home);
        courses = findViewById(R.id.menu_cours);
        people = findViewById(R.id.menu_friends);
        profile = findViewById(R.id.menu_profile);
        inscripcion =  findViewById(R.id.btn_Inscripcion_curso);

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


        recycler = findViewById(R.id.Recycler_Temario);
        recycler2 = findViewById(R.id.Recycler_FeedBack);

        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataListTem = temario_controller.ShowTopics(Course.get_course_id(),getApplicationContext());
        DataListFeed =  feedback_controller.ShowFeedback(Course.get_course_id(),getApplicationContext());

        final Adapter_temario adapter = new Adapter_temario(DataListTem);
        recycler.setAdapter(adapter);
        final Adapter_Feedback adapter2 = new Adapter_Feedback(DataListFeed);
        recycler2.setAdapter(adapter2);

        inscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inscription = userCourses_controller.Inscription(User.getUsername(),Course.get_course_id(),getApplicationContext());
                if (Inscription){
                    openOwnCourses();
                }else{
                    Toast.makeText(getApplicationContext(), "Error en la inscripcion, intente nuevamente",
                            Toast.LENGTH_SHORT).show();
                }
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