package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.CourseFeedback;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.UserCourses;

import java.util.ArrayList;

public class Feedback_controller {

    public CourseFeedback courseFeedback;
    public course Course = new course();
    private ArrayList<feedback> feedbacks;

    public Feedback_controller() { }

    public ArrayList<feedback> ShowFeedback(int course_id, Context context) {
        Course = new course(course_id,"","",0);
        courseFeedback = new CourseFeedback(Course,context);
        feedbacks = courseFeedback.getFeedback();
        while(feedbacks==null){
            feedbacks = courseFeedback.getFeedback();
        }
        return feedbacks;
    }

}
