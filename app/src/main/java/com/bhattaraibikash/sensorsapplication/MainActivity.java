package com.bhattaraibikash.sensorsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvList;
    private SensorManager sensorManager;

    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvList = findViewById(R.id.tvList);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i = 0; i < sensorsList.size(); i++){
            String sensors = "";
            sensors += sensorsList.get(i).getName() + "\n";
            tvList.append(sensors);

        }


    }
}
