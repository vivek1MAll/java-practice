package com.example.chartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button butnLine, butnPie, btnBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butnLine = findViewById(R.id.button);
        butnPie = findViewById(R.id.button2);
        btnBar = findViewById(R.id.button3);

        btnBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplication(), bardemo.class));
            }
       });
//        butnPie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplication(),piedemo.class));
//            }
//        });
//        butnLine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplication(),linedemo.class));
//            }
//        });

    }
}