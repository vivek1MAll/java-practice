package com.example.assingmentnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser() ;


        if( currentUser ==null)
        {
        Intent intent=new Intent(this,singUp.class);

        startActivity(intent);
        }else{

            Intent intent1=new Intent(this,MainActivity.class);
            startActivity(intent1);
        }

    }
}