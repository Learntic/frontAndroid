package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lerntic.Controller.Login_controller;
import com.example.lerntic.Controller.UserCourses_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.UserCourses;
import com.example.lerntic.R;

import java.util.ArrayList;

public class OwnCourses extends AppCompatActivity {

    private UserCourses_controller userCourses_controller = new UserCourses_controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_courses);
        String username = getIntent().getStringExtra("Username");
        String token = getIntent().getStringExtra("Token");

        TextView textView = (TextView) findViewById(R.id.Own_courses_header);
        textView.setText(String.format("Cursos de %s", username));

        ListView simpleList = (ListView) findViewById(R.id.coursesList);

        course[] courses;

        /*courses = userCourses_controller.ShowCourses(username,token,getApplicationContext());

        String[] coursesView = new String[courses.length];

        for (int i=0;i<courses.length;i++)
        {
            coursesView[i] = courses[i].getname();
        }*/

        final String animalList[] = {"Lion","Tiger","Monkey","Elephant","Dog","Cat","Camel"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, animalList);

        simpleList.setAdapter(adapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (animalList[position].equals("Lion")) {
                    Intent nextActivity = new Intent(OwnCourses.this, MainActivity.class);
                    startActivity(nextActivity);
                }else{
                    Intent nextActivity = new Intent(OwnCourses.this, friends.class);
                    startActivity(nextActivity);
                }
            }
        });
    }
}