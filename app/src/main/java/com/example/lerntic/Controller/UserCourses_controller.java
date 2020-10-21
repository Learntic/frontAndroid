package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.UserCourses;

import java.util.ArrayList;

public class UserCourses_controller {

    public UserCourses userCourses;
    public user User = new user();
    private ArrayList<course> courses;

    public UserCourses_controller() { }

    public ArrayList<course> ShowCourses(String username, String token, Context context) {
        User = new user(username,token,"","");
        userCourses = new UserCourses(User,context);
        courses = userCourses.getcourses();
        while(courses==null){
            courses = userCourses.getcourses();
            System.out.println(courses);
        }
        return courses;
    }
}
