package com.example.spalshscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SpllashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spllash);

        new Handler().postDelayed(() -> {
            Intent iHome = new Intent(SpllashActivity.this, MainActivity.class);
            startActivity(iHome);
        }, 4000);

        Intent iHome = new Intent(SpllashActivity.this, MainActivity.class);
        startActivity(iHome);
    }
}


