package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignInQuery;
import com.example.lerntic.type.AccountInput;

import org.jetbrains.annotations.NotNull;

public class login {
    private final String TAG = "login";
    public user User ;
    public Context context ;


    public login(user User) {
        this.User = User;
        this.context = context;
        login_consult();
    }

    public user getUser() {
        return User;
    }

    public void login_consult() {

        String username = User.getUsername();
        String password = User.getPassword();
        User = new user();

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
                        next(User);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }
    public void next(user User){
            this.User = User;
    }

}




