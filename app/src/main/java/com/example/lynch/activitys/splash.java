package com.example.lynch.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lynch.R;
import com.example.lynch.sesion.Login;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    private final long SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);
        getSupportActionBar().hide();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent cambio = new Intent(getApplicationContext(), Login.class);
                startActivity(cambio);
                finish();
            }
        },SCREEN_DELAY);
    }

}