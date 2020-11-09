package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CoursesByUserIdQuery;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UserCourses {

    private final String TAG = "UserCourses";
    public ArrayList<course> courses;
    public Context context ;
    public user User;

    public UserCourses(user User, Context context) {
        this.User = User;
        this.context = context;
        GetUserCourser(context);
    }

    public synchronized void GetUserCourser(final Context context) {

        String username = User.getUsername();
        String token = User.getToken();

        ApolloConnector.setupApollo().query(
                CoursesByUserIdQuery
                        .builder()
                        .id(username)
                        .build())
                .enqueue(new ApolloCall.Callback<CoursesByUserIdQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<CoursesByUserIdQuery.Data> response) {
                        List<CoursesByUserIdQuery.CoursesByUserId> data = response.data().coursesByUserId();
                        Log.d(TAG, "Exception " + data);
                        courses = new ArrayList<>();
                        if(data!=null) {
                            for (int i = 0; i < data.size(); i++) {
                                int id = data.get(i).course_id();
                                String name = data.get(i).course_name();
                                String desc = data.get(i).course_description();
                                double score = data.get(i).course_score();
                                courses.add(new course(id, desc, name, score));
                            }
                        }
                        setCourses(courses);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public void setCourses(ArrayList<course> courses) {
        this.courses = courses;
    }

    public ArrayList<course>  getcourses() {
        return courses;
    }
}
