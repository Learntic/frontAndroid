package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CoursesByUserIdQuery;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.friend;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.MyFriendsQuery;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AddedFriends {

    private final String TAG = "AddedFriends";
    public ArrayList<friend> friends;
    public Context context ;
    public user User;

    public AddedFriends(user User, Context context) {
        this.User = User;
        this.context = context;
        GetUserfriends(context);
    }

    public synchronized void GetUserfriends(final Context context) {

        String username = User.getUsername();
        String id = User.getid();
        String token = User.getToken();

        ApolloConnector.setupApollo().query(
                MyFriendsQuery
                        .builder()
                        .id(id)
                        .token(token)
                        .build())
                .enqueue(new ApolloCall.Callback<MyFriendsQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<MyFriendsQuery.Data> response) {
                        List<MyFriendsQuery.MyFriend> data = response.data().myFriends();
                        friends = new ArrayList<>();
                        Log.d(TAG, "Exception " + data);
                        for (int i = 0; i<data.size(); i++){
                            String fullname = data.get(i).fullname();
                            String username = data.get(i).username();
                            int age = data.get(i).age();
                            String error = data.get(i).error();
                            friends.add(new friend(fullname,username,age,error));
                        }
                        setFriends(friends);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public void setFriends(ArrayList<friend> friends) {
        this.friends = friends;
    }

    public ArrayList<friend>  getfriends() {
        return friends;
    }

}
