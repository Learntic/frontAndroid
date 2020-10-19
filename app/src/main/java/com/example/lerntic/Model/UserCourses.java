package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignInQuery;
import com.example.lerntic.type.AccountInput;
import com.example.lerntic.Model.Objects.course;

import org.jetbrains.annotations.NotNull;

public class UserCourses {

    private final String TAG = "UserCourses";
    public course[] courses ;
    public Context context ;
    public user User;

    public UserCourses(user User, Context context) {
        this.User = User;
        this.context = context;
        GetUserCourser(context);
    }

    public synchronized void GetUserCourser(final Context context) {

        String username = User.getUsername();
        String password = User.getToken();
        User = new user();

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
                        SignInQuery.SignIn data = response.data().signIn();
                        User.setToken(data.token());
                        User.setUsername(data.username());
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public course[] getcourses() {
        return courses;
    }
}
