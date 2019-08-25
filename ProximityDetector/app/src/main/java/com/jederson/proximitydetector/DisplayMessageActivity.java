package com.jederson.proximitydetector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private static int SENSOR_SENSITIVITY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textEmail);
        textView.setText(message);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        Spinner editSensitivity = findViewById(R.id.editSensitivity);
        editSensitivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                String s = String.valueOf(adapterView.getItemAtPosition(pos));
                SENSOR_SENSITIVITY = Integer.parseInt(s.split(" ")[0]);
                Log.d("Sensibilidade do Sensor", "Sensibilidade alterada para " + SENSOR_SENSITIVITY);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        mSensorManager.unregisterListener(this);
    }

    public void onOffSensor(View view) {
        Switch aSwitch = (Switch) findViewById(R.id.switchSensor);
        if (aSwitch.isChecked()) {
            aSwitch.setText(R.string.desativar_sensor);
            mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            aSwitch.setText(R.string.ativar_sensor);
            mSensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            TextView textView = findViewById(R.id.textSensor);
            if (event.values[0] >= -SENSOR_SENSITIVITY && event.values[0] <= SENSOR_SENSITIVITY) {
                // near
//                Toast.makeText(getApplicationContext(), "near", Toast.LENGTH_SHORT).show();
                textView.setText("Perto");
                Log.d("Sensibilidade do Sensor", "Perto");
            } else {
                // far
//                Toast.makeText(getApplicationContext(), "far", Toast.LENGTH_SHORT).show();
                textView.setText("Longe");
                Log.d("Sensibilidade do Sensor", "Longe");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
