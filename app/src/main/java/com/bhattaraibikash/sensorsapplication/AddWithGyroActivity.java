package com.bhattaraibikash.sensorsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddWithGyroActivity extends AppCompatActivity {

    private EditText firstNum, secondNum;
    private TextView result;
    private Button btnCalc;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_with_gyro);


        firstNum = findViewById(R.id.firstNum);
        secondNum = findViewById(R.id.secondNum);
        firstNum = findViewById(R.id.firstNum);
        result = findViewById(R.id.result);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

                Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

                SensorEventListener sel = new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent event) {
                        if(event.values[1] < 0){
                            int diff = Integer.parseInt(firstNum.getText().toString())-Integer.parseInt(firstNum.getText().toString());
                            result.setText(diff+"");

                        } else if (event.values[1] > 0) {
                            int sum = Integer.parseInt(firstNum.getText().toString())+Integer.parseInt(firstNum.getText().toString());
                            result.setText(sum+"");
                        }
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int accuracy) {

                    }
                };

                if (sensor != null){
                    sensorManager.registerListener(sel , sensor, SensorManager.SENSOR_DELAY_NORMAL);
                } else {
                    Toast.makeText(AddWithGyroActivity.this, "No Sensor Found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
