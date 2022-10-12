package com.example.simple_app;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug","i am through an error");
        Log.e("error","this is an error");
        Log.w("warn","this is data breach warning");
        Log.i("information","this is only an information");

    }
}