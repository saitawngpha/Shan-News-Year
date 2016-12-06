package com.saitawngpha.shannewyear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.yang.firework.FireworkView;
import com.yang.firework.ParticleLayer;

/**
 * Created by Sai Pha on 11/28/2016.
 */

public class SplashScreen extends AppCompatActivity{
    private static int SPLASH_TIME_OUT = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final FireworkView fireworkView = (FireworkView) findViewById(R.id.firework);
        fireworkView.queueEvent(new Runnable() {
            @Override
            public void run() {
                fireworkView.setParticleSystem(new ParticleLayer(SplashScreen.this, R.raw.snow, R.drawable.particle_texture));
            }
        });

        fireworkView.queueEvent(new Runnable() {
            @Override
            public void run() {
                fireworkView.setParticleSystem(new ParticleLayer(SplashScreen.this,R.raw.rain,R.drawable.rain_texture));
            }
        });

        fireworkView.queueEvent(new Runnable() {
            @Override
            public void run() {
                fireworkView.setParticleSystem(new ParticleLayer(SplashScreen.this,R.raw.test,R.drawable.particle_texture));
            }
        });

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, ShanNewYear.class);
                startActivity(i);
                //fadeIn();

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
