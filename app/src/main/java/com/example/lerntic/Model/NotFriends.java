package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.Model.Objects.People;
import com.example.lerntic.Model.Objects.friend;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.MyFriendsQuery;
import com.example.lerntic.NotMyFriendsQuery;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotFriends {

    private final String TAG = "NotFriends";
    public ArrayList<People> people;
    public Context context ;
    public user User;

    public NotFriends(user User, Context context) {
        this.User = User;
        this.context = context;
        GetPeople(context);
    }

    public synchronized void GetPeople(final Context context) {

        String username = User.getUsername();
        String id = User.getid();
        String token = User.getToken();

        ApolloConnector.setupApollo().query(
                NotMyFriendsQuery
                        .builder()
                        .id(id)
                        .token(token)
                        .build())
                .enqueue(new ApolloCall.Callback<NotMyFriendsQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<NotMyFriendsQuery.Data> response) {
                        List<NotMyFriendsQuery.NotMyFriend> data = response.data().notMyFriends();
                        people = new ArrayList<>();
                        Log.d(TAG, "Response " + data);
                        if(data!=null) {
                            for (int i = 0; i < data.size(); i++) {
                                String fullname = data.get(i).fullname();
                                String username = data.get(i).username();
                                String uid = data.get(i).uid();
                                people.add(new People(fullname, username, uid, ""));
                            }
                        }
                        setPeople(people);
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }

    public void setPeople(ArrayList<People> people) {
        this.people = people;
    }

    public ArrayList<People>  getPeople() {
        return people;
    }

}
