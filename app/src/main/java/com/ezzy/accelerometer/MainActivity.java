package com.ezzy.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xValue, yValue, zValue;
    private TextView xGyroscopeValue, yGyroscopeValue, zGyroscopeValue;
    private TextView xMagneticValue, yMagneticValue, zMagneticValue;
    private TextView light, pressure, humidity, temperature;

    private static final String TAG = "MainActivity";
    private SensorManager sensorManager;
    private Sensor accelerometer, gyroscope, magnetic, mLight, mPressure, mHumidity, mTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        zValue = findViewById(R.id.zValue);
        xGyroscopeValue = findViewById(R.id.xGyroValue);
        yGyroscopeValue = findViewById(R.id.yGyroValue);
        zGyroscopeValue = findViewById(R.id.zGyroValue);
        xMagneticValue = findViewById(R.id.xMagneticValue);
        yMagneticValue = findViewById(R.id.yMagneticValue);
        zMagneticValue = findViewById(R.id.zMagneticValue);

        light = findViewById(R.id.light);
        pressure = findViewById(R.id.pressure);
        humidity = findViewById(R.id.hunidity);
        temperature = findViewById(R.id.temperature);

        Log.d(TAG, "onCreate: INITIALIZING SENSOR");

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null){
            sensorManager.registerListener(MainActivity.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR ACCELEROMETER");
        }else {
            xValue.setText("Accelerometer not supported");
            yValue.setText("Accelerometer not supported");
            zValue.setText("Accelerometer not supported");

            xValue.setTextColor(getResources().getColor(R.color.red));
            yValue.setTextColor(getResources().getColor(R.color.red));
            zValue.setTextColor(getResources().getColor(R.color.red));
        }

        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null){
            sensorManager.registerListener(MainActivity.this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR GYROSCOPE");
        }else {
            xGyroscopeValue.setText("Gyroscope not supported");
            yGyroscopeValue.setText("Gyroscope not supported");
            zGyroscopeValue.setText("Gyroscope not supported");

            xGyroscopeValue.setTextColor(getResources().getColor(R.color.red));
            yGyroscopeValue.setTextColor(getResources().getColor(R.color.red));
            zGyroscopeValue.setTextColor(getResources().getColor(R.color.red));
        }

        magnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magnetic != null){
            sensorManager.registerListener(MainActivity.this, magnetic, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR MAGNETIC");
        }else {
            xMagneticValue.setText("Magnetic not supported");
            yMagneticValue.setText("Magnetic not supported");
            zMagneticValue.setText("Magnetic not supported");

            xMagneticValue.setTextColor(getResources().getColor(R.color.red));
            yMagneticValue.setTextColor(getResources().getColor(R.color.red));
            zMagneticValue.setTextColor(getResources().getColor(R.color.red));
        }

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mLight != null){
            sensorManager.registerListener(MainActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR LIGHT");
        }else {
            light.setText("Light Sensor not supported");
            light.setTextColor(getResources().getColor(R.color.red));
        }

        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mPressure != null){
            sensorManager.registerListener(MainActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR PRESSURE");
        }else {
            pressure.setText("Pressure Sensor not supported");
            pressure.setTextColor(getResources().getColor(R.color.red));
        }

        mHumidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (mHumidity != null){
            sensorManager.registerListener(MainActivity.this, mHumidity, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR HUMIDITY");
        }else {
            humidity.setText("Humidity Sensor not supported");
            humidity.setTextColor(getResources().getColor(R.color.red));
        }

        mTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (mTemperature != null){
            sensorManager.registerListener(MainActivity.this, mTemperature, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "onCreate: REGISTERING SENSOR TEMPERATURE");
        }else {
            temperature.setText("Temperature Sensor not supported");
            temperature.setTextColor(getResources().getColor(R.color.red));
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
//        Log.d(TAG, "onSensorChanged: values >>> X:[ " + event.values[0] + " ]  Y:[ "
//                + event.values[1] + " ] Z:[ " + event.values[2] + " ]");

        Sensor sensor = event.sensor;
        switch (sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                xValue.setText("X Value: " + event.values[0]);
                yValue.setText("Y Value: " + event.values[1]);
                zValue.setText("Z Value: " + event.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                xGyroscopeValue.setText("X Gyro Value: " + event.values[0]);
                yGyroscopeValue.setText("Y Gyro Value: " + event.values[1]);
                zGyroscopeValue.setText("Z Gyro Value: " + event.values[2]);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                xMagneticValue.setText("X Magnet Value: " + event.values[0]);
                yMagneticValue.setText("Y Magnet Value: " + event.values[1]);
                zMagneticValue.setText("Z Magnet Value: " + event.values[2]);
                break;
            case Sensor.TYPE_LIGHT:
                light.setText("Light: " + event.values[2]);
                break;
            case  Sensor.TYPE_PRESSURE:
                pressure.setText("Pressure: " + event.values[0]);
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                humidity.setText("Humidity: " + event.values[0]);
                break;
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                temperature.setText("Temperature: " + event.values[0]);
                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}