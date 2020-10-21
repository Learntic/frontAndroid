package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CreateFeedbackMutation;
import com.example.lerntic.Model.Objects.feedback;
import com.example.lerntic.type.FeedbackInput;
import org.jetbrains.annotations.NotNull;

public class WriteFeedbackFunc {

    private final String TAG = "WriteFeedback";
    public feedback feedbackF;
    public Context context ;
    public String token;

    public WriteFeedbackFunc(Context context, String token, feedback feedbackX) {
        this.context = context;
        this.token = token;
        this.feedbackF = feedbackX;
        writeFeedback(context);
    }

    public synchronized void writeFeedback(final Context context) {

        FeedbackInput feedbackInput = FeedbackInput
                .builder()
                .id_curso(Integer.parseInt(feedbackF.getId_usuario()))
                .nota(feedbackF.getNota())
                .id_usuario(feedbackF.getId_usuario())
                .opinion(feedbackF.getOpinion())
                .build();

        ApolloConnector.setupApollo().mutate(
                CreateFeedbackMutation
                        .builder()
                        .feedback(feedbackInput)
                        .token(token)
                        .build())
                .enqueue(new ApolloCall.Callback<CreateFeedbackMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<CreateFeedbackMutation.Data> response) {
                        System.out.println("FEEDBACK RES = "+response);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

}
