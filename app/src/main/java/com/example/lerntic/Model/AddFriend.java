package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.AddFriendMutation;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.type.FriendshipInput;

import org.jetbrains.annotations.NotNull;

public class AddFriend {

    private final String TAG = "addFriend";
    public user u;
    public String friendUid;
    public Context context ;
    public boolean res;

    public AddFriend(user u, Context context, String friendUid) {
        this.u = u;
        this.context = context;
        this.friendUid = friendUid;
        addFriend(context);
    }

    public synchronized void addFriend(final Context context) {

        FriendshipInput friendshipInput = FriendshipInput
                .builder()
                .from(u.getid())
                .to(friendUid)
                .build();

        ApolloConnector.setupApollo().mutate(
                AddFriendMutation
                        .builder()
                        .data(friendshipInput)
                        .build())
                .enqueue(new ApolloCall.Callback<AddFriendMutation.Data>() {

                    @Override
                    public void onResponse(@NotNull Response<AddFriendMutation.Data> response) {
                        Log.d(TAG, "addFriend response " + response.data());
                        if (response.data() == null){
                            Toast.makeText(context, "Error agregando amigo",
                                    Toast.LENGTH_SHORT).show();
                            setRes(false);
                        }else {
                            System.out.println("agregando amigo");
                            Toast.makeText(context, "Amigo agregado",
                                    Toast.LENGTH_SHORT).show();
                            setRes(true);
                        }
                    }

                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Register Exception " + e);
                        Toast.makeText(context, "Error agregando amigo",
                                Toast.LENGTH_SHORT).show();
                        setRes(false);
                    }
                });

    }

    public void setRes(boolean res){
        this.res = res;
    }

    public boolean getRes() {
        return res;
    }


}
