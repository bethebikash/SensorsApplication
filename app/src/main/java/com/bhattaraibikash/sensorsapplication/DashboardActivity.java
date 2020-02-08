package com.bhattaraibikash.sensorsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button btnAllSensor, btnAcc, btnGyro, btnCalcGyro, btnProx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAllSensor = findViewById(R.id.btnAllSensors);
        btnAcc = findViewById(R.id.btnAcc);
        btnGyro = findViewById(R.id.btnGyro);
        btnCalcGyro = findViewById(R.id.btnGyroCalc);
        btnProx = findViewById(R.id.btnProx);

        btnAllSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AccelerometerActivity.class);
                startActivity(intent);
            }
        });

        btnGyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, GyroscopeActivity.class);
                startActivity(intent);
            }
        });

        btnCalcGyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AddWithGyroActivity.class);
                startActivity(intent);
            }
        });

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ProximityActivity.class);
                startActivity(intent);
            }
        });
    }
}
