package com.example.lerntic.Controller;

import android.content.Context;
import com.example.lerntic.GetAchievementsByUsernamesQuery;
import com.example.lerntic.Model.Achievements;
import com.example.lerntic.Model.Objects.Achievement;
import com.example.lerntic.Model.Objects.user;

import java.util.ArrayList;
import java.util.List;

public class Achievements_controller {

    public Achievements achievements;
    public user User = new user();
    private ArrayList<Achievement> achievementsList;

    public Achievements_controller(){}

    public ArrayList<Achievement> showAchievements(String username, String token, Context context){
        User = new user(username,token,"","");
        achievements = new Achievements(User, context);
        achievementsList = achievements.getAchievements();
        while(achievementsList == null){
            achievementsList = achievements.getAchievements();
        }
        return achievementsList;
    }
}
