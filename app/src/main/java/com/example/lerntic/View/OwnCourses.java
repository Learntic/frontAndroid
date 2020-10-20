package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lerntic.Controller.UserCourses_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

public class OwnCourses extends AppCompatActivity {

    private UserCourses_controller userCourses_controller = new UserCourses_controller();

    //----------Botton MENU
    public LinearLayout home;
    public LinearLayout courses;
    public LinearLayout friends;
    public LinearLayout profile;
    //---------

    public user User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_courses);

        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");

        User = new user(username,token,"");

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

        TextView textView = (TextView) findViewById(R.id.Not_Own_courses_header);
        textView.setText(String.format("Cursos de %s", username));

        ListView simpleList = (ListView) findViewById(R.id.coursesList);

        final course[] courses;

        courses = userCourses_controller.ShowCourses(username,token,getApplicationContext());

        if (courses.length==0){
            String[] NotCourses = {"No se encuentra inscrito en ningun curso"};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NotCourses);

            simpleList.setAdapter(adapter);
        }else {
            ArrayAdapter<course> adapter = new ArrayAdapter<course>(this, android.R.layout.simple_list_item_1, courses);

            simpleList.setAdapter(adapter);

            simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // openCourse(courses[position]);
                }
            });
        }
    }

    public void openCourse(course course){
        Intent intent = new Intent(this, CourseActivity.class);
        intent.putExtra("Username",User.getUsername());
        intent.putExtra("Token",User.getToken());
        intent.putExtra("course_id",course.get_course_id());
        intent.putExtra("course_name",course.get_name());
        intent.putExtra("course_description",course.get_course_description());
        intent.putExtra("course_score",course.get_course_score());
        startActivity(intent);
    }
}