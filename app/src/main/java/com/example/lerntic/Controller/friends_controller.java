package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.AddFriend;
import com.example.lerntic.Model.AddedFriends;
import com.example.lerntic.Model.NotFriends;
import com.example.lerntic.Model.Objects.People;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.friend;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.UserCourses;

import java.util.ArrayList;

public class friends_controller {

    public AddedFriends addedFriends;
    public NotFriends notFriends;
    public AddFriend addFriend;
    public user User = new user();
    private ArrayList<friend> friends;
    private ArrayList<People> Notfriends;

    public friends_controller() { }

    public ArrayList<friend> Showfriends(String username, String token,String id, Context context) {
        User = new user(username,token,"",id);
        addedFriends = new AddedFriends(User,context);
        friends = addedFriends.getfriends();
        while(friends==null){
            friends = addedFriends.getfriends();
        }
        return friends;
    }

    public ArrayList<People> ShowNotfriends(String username, String token,String id, Context context) {
        User = new user(username,token,"",id);
        notFriends = new NotFriends(User,context);
        Notfriends = notFriends.getPeople();
        while(Notfriends == null){
            Notfriends = notFriends.getPeople();
        }
        return Notfriends;
    }

    public boolean addFriend(String username, String token,String id, Context context, String friendUid){
        User = new user(username,token,"",id);
        addFriend = new AddFriend(User, context, friendUid);
        addFriend.addFriend(context);
        boolean res = addFriend.getRes();
        while(res == false)
            addFriend.addFriend(context);
        return  res;
    }
}
