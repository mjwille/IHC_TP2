package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private TextView textX, textY, textZ;
    private float x, y, z;
    private boolean first = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        textX = findViewById(R.id.accX);
        textY = findViewById(R.id.accY);
        textZ = findViewById(R.id.accZ);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float new_x = event.values[0];
            float new_y = event.values[1];
            float new_z = event.values[2];

            textX.setText(String.valueOf(new_x));
            textY.setText(String.valueOf(new_y));
            textZ.setText(String.valueOf(new_z));

            if(!first) {
                // Troca Activity se variação em X for maior que 10
                if(Math.abs(new_x - x) > 10) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }

            x = new_x;
            y = new_y;
            z = new_z;

            first = false;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}