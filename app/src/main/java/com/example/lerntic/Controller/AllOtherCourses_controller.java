package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.NotUserCourses;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;

import java.util.ArrayList;

public class AllOtherCourses_controller {

    public NotUserCourses notuserCourses;
    public user User = new user();
    public ArrayList<course> courses;

    public AllOtherCourses_controller() { }

    public ArrayList<course> ShowCourses(String username, String token, Context context) {
        User = new user(username,token,"");
        notuserCourses = new NotUserCourses(User,context);
        courses = notuserCourses.getcourses();
        while(courses==null){
            courses = notuserCourses.getcourses();
        }
        return courses;
    }

}
