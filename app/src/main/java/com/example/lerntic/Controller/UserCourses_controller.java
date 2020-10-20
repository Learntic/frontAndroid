package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.login;
import com.example.lerntic.Model.UserCourses;

public class UserCourses_controller {

    public UserCourses userCourses;
    public user User = new user();
    public course[] courses;

    public UserCourses_controller() { }

    public course[] ShowCourses(String username, String token, Context context) {
        User = new user(username,token,"");
        userCourses = new UserCourses(User,context);
        courses = userCourses.getcourses();
        while(courses==null){
            courses = userCourses.getcourses();
        }
        return courses;
    }
}
