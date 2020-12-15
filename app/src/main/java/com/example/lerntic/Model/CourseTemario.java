package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CourseTopicsQuery;
import com.example.lerntic.FeedbackByCourseQuery;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.temario;
import com.example.lerntic.type.AccountInput;
import com.example.lerntic.type.EnteroInput;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CourseTemario {

    private final String TAG = "CourseTemario";
    public ArrayList<temario> temarios;
    public Context context ;
    public course Course;

    public CourseTemario(course course, Context context) {
        this.Course = course;
        this.context = context;
        GetCourseTopics(context);
    }

    public synchronized void GetCourseTopics(final Context context) {

        int course_id = Course.get_course_id();

        EnteroInput enteroInput = EnteroInput
                .builder()
                .entero(course_id)
                .build();

        ApolloConnector.setupApollo().query(
                CourseTopicsQuery
                        .builder()
                        .entero(enteroInput)
                        .build())
                .enqueue(new ApolloCall.Callback<CourseTopicsQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<CourseTopicsQuery.Data> response) {
                        Log.d(TAG, "CourseTemario Response" + response);
                        System.out.println("----------------------TEMARIOS--------------------");
                        System.out.println(response.data().courseTopics());
                        List<CourseTopicsQuery.CourseTopic> data = response.data().courseTopics();
                        Log.d(TAG, "CourseTemario data" + data);
                        temarios = new ArrayList<>();
                        for (int i = 0; i<data.size(); i++){
                            int topic_id = data.get(i).topic_id();
                            String topic_description = data.get(i).topic_description();
                            String topic_name = data.get(i).topic_name();
                            temarios.add(new temario(topic_id,topic_description,topic_name));
                        }
                        setTopics(temarios);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public void setTopics(ArrayList<temario> temarios) {
        this.temarios = temarios;
    }

    public ArrayList<temario>  getTopics() {
        return temarios;
    }

}
