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
    public user u;
    public Context context ;

    public Consultar(user u) {
        this.u = u;
        this.context = context;
        getUserQuery();
    }

    public user getUser() {
        return u;
    }

    public void getUserQuery() {

        String id = u.getid();
        String token = u.getPassword();
        u = new user();

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
                            u.setToken("");
                            u.setUsername("");
                            u.setid("-1");
                            next(u);
                        }else {
                            GetUserQuery.GetUser data = response.data().getUser();
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
