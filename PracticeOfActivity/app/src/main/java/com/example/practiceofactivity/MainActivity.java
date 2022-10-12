package com.example.practiceofactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity lifecycle ", "onStart invoked ");
    }

    @Override
        @SuppressLint("LongLogTag")
        protected void onStart () {
        super.onStart();
        Log.d("activity lifecycle","Activity Started");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("Activity Lifecycle ","activity resume");

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d("Activity lifecycle ","the Activity is on pause ");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("Activity lifecycle","the activity is on restart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("Activity lifecycle", "the activity is on restart");

    }



    }
