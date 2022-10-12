package com.example.my_login_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.Password);

        MaterialButton LoginBtn=(MaterialButton) findViewById(R.id.loginButton);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                   correct
                    Toast.makeText(MainActivity.this, "login valid", Toast.LENGTH_SHORT).show();
                } else
//                    not correct
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}