package com.example.lerntic.Model;

import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignInQuery;
import com.example.lerntic.type.AccountInput;

import org.jetbrains.annotations.NotNull;

public class login {
    private final String TAG = "MainActivity";
    public user user_return = new user();

    public Object login(user User) {

        String username = User.getUsername();
        String password = User.getPassword();

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
                        user_return.setToken(data.token());
                        user_return.setUsername(data.username());
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
        return user_return;
    }

}
