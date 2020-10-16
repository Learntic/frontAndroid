package com.example.lerntic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getfeedbackByID(1);

    }

    private void getfeedbackByID(int id){

        ApolloConnector.setupApollo().query(
                FeedbacksQuery
                        .builder()
                        .id(id)
                        .build())
                .enqueue(new ApolloCall.Callback<FeedbacksQuery.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<FeedbacksQuery.Data> response) {

                        Log.d(TAG, "Response: " + response.data().feedbackById);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {

                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }
}