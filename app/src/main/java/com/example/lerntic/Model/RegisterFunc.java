package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.SignInQuery;
import com.example.lerntic.SignUpMutation;
import com.example.lerntic.type.AccountInput;
import com.example.lerntic.type.RegisterInput;

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
        String name = user.getName();
        int age = user.getAge();

        RegisterInput account = RegisterInput
                .builder()
                .username(username)
                .password(password)
                .name(name)
                .age(age)
                .build();

        ApolloConnector.setupApollo().mutate(
                SignUpMutation
                        .builder()
                        .account(account)
                        .build())
                .enqueue(new ApolloCall.Callback<SignUpMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<SignUpMutation.Data> response) {
                        Log.d(TAG, "Register response " + response.data());
                        user = new user();
                        if (response.data() == null){
                            user.setToken("");
                            user.setUsername("");
                            user.setName("");
                            user.setAge(0);
                            user.setid("-1");
                            setUser(user);
                        }else {
                            System.out.println("entro");
                            SignUpMutation.SignUp data = response.data().signUp();
                            System.out.println(data.username());
                            Log.d(TAG, "Register response " + response.data());
                            user.setToken(data.token());
                            user.setUsername(data.username());
                            user.setid(data.uid());
                            user.setName(data.name());
                            user.setAge(data.age());
                            System.out.println("USER"+user);
                            setUser(user);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Register Exception " + e);
                        user.setToken("");
                        user.setUsername("");
                        user.setName("");
                        user.setAge(0);
                        user.setid("-1");
                        setUser(user);
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
