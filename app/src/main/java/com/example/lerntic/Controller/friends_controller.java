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
    private ArrayList<People> NotfriendsList;
    boolean NotRecived = true;

    public friends_controller() { }

    public ArrayList<friend> Showfriends(String username, String token,String id, Context context) {
        NotRecived = true;
        User = new user(username,token,"",id);
        addedFriends = new AddedFriends(User,context);
        friends = addedFriends.getfriends();
        while(NotRecived){
            friends = addedFriends.getfriends();
            NotRecived = !addedFriends.getRecive();
        }
        return friends;
    }

    public ArrayList<People> ShowNotfriends(String username, String token,String id, Context context) {
        NotRecived = true;
        User = new user(username,token,"",id);
        notFriends = new NotFriends(User,context);
        NotfriendsList = notFriends.getPeople();
        while(NotRecived){
            NotfriendsList = notFriends.getPeople();
            NotRecived = !notFriends.getRecived();
        }
        System.out.println("NOTFRIENDS "+NotfriendsList.get(0).getFullname());
        return NotfriendsList;
    }

    public boolean addFriend(String username, String token,String id, Context context, String friendUid){
        NotRecived = true;
        User = new user(username,token,"",id);
        addFriend = new AddFriend(User, context, friendUid);
        boolean res = addFriend.getRes();
        while(NotRecived){
            res = addFriend.getRes();
            NotRecived = !addFriend.getresponse();
        }
        return  res;
    }
}
