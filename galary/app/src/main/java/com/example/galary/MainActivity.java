package com.example.galary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.provider.MediaStore;

import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE=100;
    ImageView imageGallry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageGallry=findViewById(R.id.imageView);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(view -> {
            Intent iGallery=new Intent(Intent.ACTION_PICK);
            iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(iGallery,REQUEST_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
// Gallary app
            if (requestCode==REQUEST_CODE){
                imageGallry.setImageURI(data.getData());
//                imageGallery.setImageResource(c);
            }

        }

    }
}