package com.example.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleFlashLightOnOff;
    private CameraManager cameraManager;
    private String getCameraId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleFlashLightOnOff=findViewById(R.id.toggle_flashLight);

        cameraManager=(CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            getCameraId=cameraManager.getCameraIdList()[0];
        }catch(CameraAccessException e){
            e.printStackTrace();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void toggleFlashlight (View view){
        if(toggleFlashLightOnOff.isChecked()){
            try {
                cameraManager.setTorchMode(getCameraId,true);

                Toast.makeText(MainActivity.this,"Flashlight is turned ON",Toast.LENGTH_SHORT).show();
            }catch( CameraAccessException e){
                e.printStackTrace();
            }
        }else{
            try {
                cameraManager.setTorchMode(getCameraId,false);
                Toast.makeText(MainActivity.this,"Flashlight is turned OFF",Toast.LENGTH_SHORT).show();
            }catch(CameraAccessException e){
                e.printStackTrace();
            }
        }

    }
    @RequiresApi(api =Build.VERSION_CODES.M)
    @Override
    public void finish(){
        super.finish();
        try {
            cameraManager.setTorchMode(getCameraId,false);



        }catch (CameraAccessException e){
            e.printStackTrace();
        }
    }

}