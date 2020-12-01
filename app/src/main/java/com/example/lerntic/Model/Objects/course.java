package com.example.lerntic.Model.Objects;

public class course {
    int course_id;
    String course_description;
    String course_name;
    double course_score;

    public course(){};

    public course(int course_id, String course_description, String course_name, double course_score) {
        this.course_id = course_id;
        this.course_description = course_description;
        this.course_name = course_name;
        this.course_score = course_score;
    }

    public String get_name() {
        return course_name;
    }

    public void set_name(String name) {
        this.course_name = name;
    }

    public int get_course_id() {
        return course_id;
    }

    public void set_course_id(int course_id) {
        this.course_id = course_id;
    }

    public String  get_course_description() {
        return course_description;
    }

    public void set_course_description(String course_description) {
        this.course_description = course_description;
    }

    public double get_course_score() {
        return course_score;
    }

    public void set_course_score(double course_score) {
        this.course_score = course_score;
    }

}
