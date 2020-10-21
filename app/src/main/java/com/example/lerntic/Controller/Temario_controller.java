package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.CourseFeedback;
import com.example.lerntic.Model.CourseTemario;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.temario;

import java.util.ArrayList;

public class Temario_controller {

    public CourseTemario courseTemario;
    public course Course = new course();
    private ArrayList<temario> temarios;

    public Temario_controller() { }

    public ArrayList<temario> ShowTopics(int course_id, Context context) {
        Course = new course(course_id,"","",0);
        courseTemario = new CourseTemario(Course,context);
        temarios = courseTemario.getTopics();
        while(temarios==null){
            temarios = courseTemario.getTopics();
        }
        return temarios;
    }

}
