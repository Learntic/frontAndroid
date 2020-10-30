package com.example.lerntic.Model;

import android.content.Context;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.lerntic.CoursesByNotUserIdQuery;
import com.example.lerntic.GetAchievementsByUsernamesQuery;
import com.example.lerntic.Model.Objects.Achievement;
import com.example.lerntic.Model.Objects.course;
import com.example.lerntic.Model.Objects.user;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Achievements {

    private final String TAG = "Achievements";
    public ArrayList<Achievement> achievementsL;
    public Context context;
    public user User;

    public Achievements(user User, Context context) {
        this.User = User;
        this.context = context;
        GetAchievements(context);
    }

    public synchronized void GetAchievements(final Context context) {

        final String username = User.getUsername();
        String token = User.getToken();
        ArrayList u = new ArrayList();
        u.add(username);

        ApolloConnector.setupApollo().query(
                GetAchievementsByUsernamesQuery
                        .builder()
                        .names(u)
                        .build())
                .enqueue(new ApolloCall.Callback<GetAchievementsByUsernamesQuery.Data>() {
                    @Override
                    public void onResponse(@NotNull Response<GetAchievementsByUsernamesQuery.Data> response) {
                        List<GetAchievementsByUsernamesQuery.GetAchievementsByUsername> data = response.data().GetAchievementsByUsernames();
                        Log.d(TAG, "Achiv " + data);
                        achievementsL = new ArrayList<>();
                        for (int i = 0; i < data.get(0).achievements().size(); i++) {
                            String description = data.get(0).achievements().get(i).description();
                            System.out.println(description);
                            achievementsL.add(new Achievement(description));
                        }
                        setAchievements(achievementsL);
                    }
                    @Override
                    public void onFailure(@NotNull ApolloException e) {
                        Log.d(TAG, "Exception " + e.getMessage(), e);
                    }
                });
    }
    public void setAchievements(ArrayList<Achievement>  achievements) {
        this.achievementsL = achievements;
    }

    public ArrayList<Achievement>  getAchievements() {
        return achievementsL;
    }

}
