package com.tp4.nfa024.cnam.boussole;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends Activity implements SensorEventListener
{

    private SensorManager sm;
    private Sensor magnetometre;
    private VueBoussole v;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.sm = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        this.magnetometre = this.sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        this.v = (VueBoussole)this.findViewById(R.id.main_boussole_mvb);
    }


    @Override
    public void onSensorChanged(SensorEvent data) {
       /*
        data.values[0]; //intensité du champ magnétique en X exprimé en microTesla
        data.values[1]; //intensité du champ magnétique en Y exprimé en microTesla

       // data.values[2]; //intensité du champ magnétique en Z exprimé en microTesla
        */

       final double i = Math.sqrt(data.values[0]* data.values[0]
       + data.values[1]* data.values[1]);

        final double px = data.values[0]/i;
        final double py = data.values[1]/i;
        double angleX = Math.acos(px);
        double angleY = Math.asin(py);
        final double angle = Math.signum(angleY)*angleX;
        this.v.setAngle((float)angle);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume(){
        super.onResume();
        this.sm.registerListener(this,magnetometre,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause(){
        super.onPause();
        this.sm.unregisterListener(this);
    }
}
