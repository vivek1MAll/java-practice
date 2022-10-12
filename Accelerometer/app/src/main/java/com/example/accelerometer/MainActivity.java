package com.example.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txtValues);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {

            Sensor acclerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (acclerometer != null) {
                sensorManager.registerListener(this, acclerometer, SensorManager.SENSOR_DELAY_NORMAL);
            }


        } else {
            Toast.makeText(this, "sensor is not detected", Toast.LENGTH_SHORT).show();
        }


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ((TextView)findViewById(R.id.txtValues)).setText("X "+sensorEvent.values[0]+"Y"+sensorEvent.values[1]+"Z"+sensorEvent.values[2]);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}