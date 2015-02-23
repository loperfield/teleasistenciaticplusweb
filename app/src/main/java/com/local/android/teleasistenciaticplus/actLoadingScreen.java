package com.local.android.teleasistenciaticplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.local.android.teleasistenciaticplus.lib.networking.Networking;
import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.util.Timer;
import java.util.TimerTask;


public class actLoadingScreen extends ActionBarActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creación de la pantalla de carga
        setContentView(R.layout.layout_loadingscreen);

        //Se muestra la pantalla de carga y esperamos la comprobación de inicio de
        // 1. Tenemos conexión de datos
        // 2. Hay comunicación con el servidor
        // 3. EL usuario tiene acceso a la aplicación //TODO como identificamos a un usuario?


        //Comprobación de que exista conexión de datos en el teléfono
        final Boolean isNetworkAvailable = Networking.isConnectedToInternet();

        if (isNetworkAvailable == false) {

        }


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
        timer.schedule(task, Constants.LOADING_SCREEN_TIME);
    }
}

