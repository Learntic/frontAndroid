package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignUpMutation;
import com.example.lerntic.type.AccountInput;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RegisterFunc {

    private final String TAG = "register";
    public user user ;
    public Context context ;

    public RegisterFunc(user User, Context context) {
        this.user = User;
        this.context = context;
        register(context);
    }

    public synchronized void register(final Context context) {

        String username = user.getUsername();
        String password = user.getPassword();
        user = new user();

        AccountInput account = AccountInput
                .builder()
                .username(username)
                .password(password)
                .build();

        ApolloConnector.setupApollo().mutate(
                SignUpMutation
                        .builder()
                        .account(account)
                        .build())
                .enqueue(new ApolloCall.Callback<SignUpMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<SignUpMutation.Data> response) {
                        SignUpMutation.SignUp data = response.data().signUp();
                        user.setToken(data.token());
                        user.setUsername(data.username());
                        user.setid(data.uid());
                        setUser(user);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });

    }

    public void setUser(user user){
        this.user = user;
    }

    public user getUser() {
        return user;
    }
}
