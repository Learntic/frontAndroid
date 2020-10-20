package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lerntic.Controller.Adapter_Courses;
import com.example.lerntic.Controller.UserCourses_controller;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.R;

import java.util.ArrayList;

public class OwnCourses extends AppCompatActivity {

    private UserCourses_controller userCourses_controller = new UserCourses_controller();

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

        recycler = findViewById(R.id.Recycler_ownCourses);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        DataList = new ArrayList<String>();

        for (int i = 0; i<=50;i++){
            DataList.add("Curso "+i);
        }



        final Adapter_Courses adapter = new Adapter_Courses(DataList,User);
        recycler.setAdapter(adapter);
        adapter.SetOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Course_detail.class);
                intent.putExtra("Username",User.getUsername());
                intent.putExtra("Token",User.getToken());
                intent.putExtra("Course",DataList.get(recycler.getChildAdapterPosition(v)));
                v.getContext().startActivity(intent);
            }
        });

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

       /* final String animalList[] = {"Lion","Tiger","Monkey","Elephant","Dog","Cat","Camel"};

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
        });*/
    }
}