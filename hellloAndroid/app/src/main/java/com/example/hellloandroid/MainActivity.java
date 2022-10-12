package com.example.hellloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1;

        btn1=findViewById(R.id.btn);
        btn1.setOnClickListener(view -> {
            Intent inext;
            inext =new Intent(MainActivity.this,secondActivity.class);
            startActivity(inext);
        });



    }
}