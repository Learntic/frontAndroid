package com.example.lerntic.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.lerntic.R;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

public class Game extends AppCompatActivity {
    private Handler handler = new Handler();
    String username="";
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            imprimir();
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        handler.postDelayed(runnable, 1000);
        username = getIntent().getStringExtra("Username");
        Intent intent = new Intent(this, UnityPlayerActivity.class);
        intent.putExtra("Username",username);
        startActivity(intent);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    public void imprimir(){
        UnityPlayer.UnitySendMessage("User","setUsername",username);
        System.out.println("la felicidad te espera");

    }
}