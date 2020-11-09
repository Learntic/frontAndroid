package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CoursesByUserIdQuery;
import com.example.lerntic.FeedbackByCourseQuery;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.Model.Objects.user;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CourseFeedback {

    private final String TAG = "CourseFeedback";
    public ArrayList<feedback> feedbacks;
    public Context context ;
    public course Course;

    public CourseFeedback(course course, Context context) {
        this.Course = course;
        this.context = context;
        GetCourseFeedback(context);
    }

    public synchronized void GetCourseFeedback(final Context context) {

        int course_id = Course.get_course_id();

        ApolloConnector.setupApollo().query(
                FeedbackByCourseQuery
                        .builder()
                        .id_curso(course_id)
                        .build())
                .enqueue(new ApolloCall.Callback<FeedbackByCourseQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<FeedbackByCourseQuery.Data> response) {
                        List<FeedbackByCourseQuery.FeedbackByCourse> data = response.data().feedbackByCourse();
                        Log.d(TAG, "Exception " + data);
                        feedbacks = new ArrayList<>();
                        if(data!=null) {
                            for (int i = 0; i < data.size(); i++) {
                                int id = data.get(i).id();
                                String id_usuario = data.get(i).id_usuario();
                                int id_curso = data.get(i).id_curso();
                                String opinion = data.get(i).opinion();
                                double nota = data.get(i).nota();
                                feedbacks.add(new feedback(id, id_usuario, id_curso, opinion, nota));
                            }
                        }
                        setFeedbacks(feedbacks);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public void setFeedbacks(ArrayList<feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public ArrayList<feedback>  getFeedback() {
        return feedbacks;
    }
}
