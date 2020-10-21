package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.inscription;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.UserCourses;
import com.example.lerntic.Model.UserInscription;

import java.util.ArrayList;

public class UserCourses_controller {

    public UserCourses userCourses;
    public UserInscription userInscription;
    public user User = new user();
    private ArrayList<course> courses;
    public inscription Inscription = new inscription();

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

    public boolean Inscription(String username, int course_id, Context context) {
        Inscription = new inscription(0,username,course_id,0);
        userInscription = new UserInscription(Inscription,context);
        Inscription = userInscription.getInscription();
        while(Inscription==null){
            Inscription = userInscription.getInscription();
        }
        if (Inscription.getId_usuario()==username){
            return true;
        }
        return false;
    }
}
