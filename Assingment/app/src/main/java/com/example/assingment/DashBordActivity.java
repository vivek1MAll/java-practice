package com.example.assingment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assingment.databinding.ActivityDashbordBinding;
import com.example.assingment.databinding.ActivitySignUpBinding;

public class DashBordActivity extends AppCompatActivity {

    ActivityDashbordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityDashbordBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());


    }
}