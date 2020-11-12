package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

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
    public user User;
    public Context context ;
    boolean Recibir = false;

    public Actualizar(user user, Context context) {
        this.User = user;
        this.context = context;
        getUserMutation();
    }

    public user getUser() {
        return User;
    }

    public boolean getRecibir() {
        return Recibir;
    }

    public void getUserMutation() {

        String id = User.getid();
        String token = User.getToken();

        UpdateUserInput updateUserInput = UpdateUserInput
                .builder()
                .age(User.getAge())
                .email(User.getEmail())
                .fullname(User.getName())
                .username(User.getUsername())
                .build();

        User = new user();

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
                        Log.d(TAG, "Response " + response.data());
                        if (response.data() == null){
                            User.setToken("");
                            User.setUsername("");
                            User.setid("-1");
                            next(User);
                        }else {
                            UpdateUserMutation.UpdateUser data = response.data().updateUser();
                            User.setAge(data.age());
                            User.setEmail(data.email());
                            User.setName(data.fullname());
                            User.setid("1");
                            next(User);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        User.setToken("");
                        User.setUsername("");
                        User.setid("-1");
                        next(User);
                    }
                });
    }
    public void next(user user){
        this.User = user;
        this.Recibir = true;
    }


}
