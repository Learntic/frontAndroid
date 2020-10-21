package com.example.lerntic.Controller;

import android.content.Context;

import com.example.lerntic.Model.AddedFriends;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.friend;
import com.example.lerntic.Model.Objects.user;
import com.example.lerntic.Model.UserCourses;

import java.util.ArrayList;

public class friends_controller {

    public AddedFriends addedFriends;
    public user User = new user();
    private ArrayList<friend> friends;

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
}
