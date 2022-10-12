package com.example.accelerometersenser;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager senserManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (senserManager != null) {
            Sensor proxiSensor = senserManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proxiSensor != null) {
                senserManager.registerListener(this, proxiSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }

        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()== Sensor.TYPE_PROXIMITY){
            ((TextView)findViewById(R.id.txtValues)).setText("values "+sensorEvent.values[0]);

            if(sensorEvent.values[0]>0){
                Toast.makeText(this,"object is far",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "object is near",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}