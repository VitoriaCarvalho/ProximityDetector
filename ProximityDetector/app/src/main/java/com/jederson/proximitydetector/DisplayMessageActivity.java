package com.jederson.proximitydetector;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import android.os.Bundle;
import android.view.View;
import android.util.Log;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DisplayMessageActivity extends AppCompatActivity implements SensorEventListener, LocationListener {

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private static int SENSOR_SENSITIVITY = 4;

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;

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

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

        Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
        onLocationChanged(location);
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
//                dispatchTakePictureIntent();
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                        != PackageManager.PERMISSION_GRANTED) {
                    // Permission is not granted
                    Toast.makeText(getApplicationContext(), "Permission is not granted", Toast.LENGTH_LONG).show();
                } else {
                    // Permission is granted
                    Client client = new Client(findViewById(R.id.textEmail).toString(), longitude, latitude);
                    client.execute();
                }
            } else {
                // far
                textView.setText("Longe");
                Log.d("Sensibilidade do Sensor", "Longe");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
//        Toast.makeText(getApplicationContext(), "GPS", Integer.parseInt("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude()));
        try {
            if(location!= null){
//                double latitude = location.getLatitude();
//                double longitude = location.getLongitude();
                latitude = String.valueOf(location.getLatitude());
                longitude = String.valueOf(location.getLongitude());
                Log.d("GPS", "Latitude:" + latitude + ", Longitude:" + longitude);
            } else {
                Log.d("GPS", "Latitude: Null" + ", Longitude: Null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Latitude","status");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Latitude","disable");
    }
}
