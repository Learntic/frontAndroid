package com.example.lerntic.Model;

import android.content.Context;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.GetUserQuery;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.UpdateUserMutation;
import com.example.lerntic.type.UpdateUserInput;

import org.jetbrains.annotations.NotNull;

public class Actualizar {
    private final String TAG = "actualizar";
    public user u;
    public Context context ;

    public Actualizar(user u) {
        this.u = u;
        this.context = context;
        getUserMutation();
    }

    public user getUser() {
        return u;
    }

    public void getUserMutation() {

        String id = u.getid();
        String token = u.getPassword();
        u = new user();

        UpdateUserInput updateUserInput = UpdateUserInput
                .builder()
                .age(u.getAge())
                .email(u.getEmail())
                .fullname(u.getName())
                .username(u.getUsername())
                .build();

        ApolloConnector.setupApollo().mutate(
                UpdateUserMutation
                        .builder()
                        .id(id)
                        .user(updateUserInput)
                        .token(token)
                        .build())
                .enqueue(new ApolloCall.Callback<UpdateUserMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<UpdateUserMutation.Data> response) {
                        if (response.data() == null){
                            u.setToken("");
                            u.setUsername("");
                            u.setid("-1");
                            next(u);
                        }else {
                            UpdateUserMutation.UpdateUser data = response.data().updateUser();
                            u.setAge(data.age());
                            u.setEmail(data.email());
                            u.setName(data.fullname());
                            next(u);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        u.setToken("");
                        u.setUsername("");
                        u.setid("-1");
                        next(u);
                    }
                });
    }
    public void next(user u){
        this.u = u;
    }


}
