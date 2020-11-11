package com.example.lerntic.Model;

import android.content.Context;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.GetUserQuery;
import com.example.lerntic.Model.Objects.user;

import org.jetbrains.annotations.NotNull;

public class Consultar {
    private final String TAG = "consultar";
    public user User;
    public Context context ;

    public Consultar(user user,Context context) {
        this.User = user;
        this.context = context;
        getUserQuery();
    }

    public user getUser() {
        return User;
    }

    public void getUserQuery() {

        String id = User.getid();
        String token = User.getToken();
        User = new user();

        ApolloConnector.setupApollo().query(
                GetUserQuery
                        .builder()
                        .id(id)
                        .token(token)
                        .build())
                .enqueue(new ApolloCall.Callback<GetUserQuery.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<GetUserQuery.Data> response) {
                        if (response.data() == null){
                            User.setToken("");
                            User.setUsername("");
                            User.setid("-1");
                            next(User);
                        }else {
                            GetUserQuery.GetUser data = response.data().getUser();
                            User.setAge(data.age());
                            User.setEmail(data.email());
                            User.setName(data.fullname());
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
    }


}
