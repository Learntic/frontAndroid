package com.example.lerntic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import org.jetbrains.annotations.NotNull;

import com.example.lerntic.type.AccountInput;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    EditText usernameInput;
    EditText passwordInput;

    Button SignInButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

        SignInButtom = (Button) findViewById(R.id.btn_SignIn);

        SignInButtom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                SignInAct(username,password);
            }
        });

    }

    private void SignInAct(String username, String password){

        AccountInput account = AccountInput
                .builder()
                .username(username)
                .password(password)
                .build();

        ApolloConnector.setupApollo().query(
                SignInQuery
                        .builder()
                        .account(account)
                        .build())
                .enqueue(new ApolloCall.Callback<SignInQuery.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<SignInQuery.Data> response) {

                        Log.d(TAG, "Ok " + response.data());

                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {

                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    /*private void getfeedbackByID(int id){

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
    }*/
}