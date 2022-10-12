package com.example.bottlespiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView bottleImage;
    int currentPoint;
    int nextPoint;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottleImage=findViewById(R.id.bottle);

        bottleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinTheBottle();
            }
        });

    }

    void spinTheBottle() {

        nextPoint =new Random().nextInt(5000);
        int px=bottleImage.getWidth()/2;
        int py=bottleImage.getHeight()/2;

        Animation rotate=new RotateAnimation(currentPoint,nextPoint,px,py);

        rotate.setDuration(3000);
        rotate.setFillAfter(true);

        currentPoint=nextPoint;

        bottleImage.startAnimation(rotate);

    }

}