package com.local.android.teleasistenciaticplus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.util.Timer;
import java.util.TimerTask;


public class actLoadingScreen extends ActionBarActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creación de la pantalla de carga
        setContentView(R.layout.layout_loadingscreen);

        //Se muestra la pantalla de carga
        //el programa entra por la clase Hook, así que la inicialización general
        //no depende de esta pantalla de inicio

            TimerTask task = new TimerTask() {
                @Override
                public void run() {

                    // Comenzamos la nueva aplicación
                    Intent mainIntent;
                    mainIntent = new Intent().setClass(actLoadingScreen.this, actMain.class);
                    startActivity(mainIntent);

                    // Cerramos la ventana de carga para que salga del BackStack
                    finish();
                }
            };

            // Simulamos un lento proceso de carga
            Timer timer = new Timer();
            timer.schedule(task, Constants.LOADING_SCREEN_TIME );

    }
}

            /*TextView logText = (TextView) findViewById(R.id.text_init_activity);

            for (int i=0; i<=5 ; i++) {
                logText.setText(logText.getText() + ".");
            }*/

            /*Intent intent = new Intent(this, actMain.class);
            //Inserting delay here
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(intent);*/