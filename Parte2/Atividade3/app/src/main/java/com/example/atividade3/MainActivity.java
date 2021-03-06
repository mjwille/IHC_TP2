package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textLat, textLon;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLat = findViewById(R.id.textLat);
        textLon = findViewById(R.id.textLon);

        button = (Button) findViewById(R.id.button);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 123);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null) {
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    textLat.setText(String.valueOf(lat));
                    textLon.setText(String.valueOf(lon));
                }
            }
        });
    }
}