package com.example.draganddrop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyDBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db =new MyDBHelper(this);

        db.addContact("vivek","123");
        db.addContact("vivek","123");
        db.addContact("vivek","123");
        db.addContact("vivek","123");
        db.addContact("vivek","123");
        db.addContact("vivek","123");
        db.addContact("vivek","123");






    }
}