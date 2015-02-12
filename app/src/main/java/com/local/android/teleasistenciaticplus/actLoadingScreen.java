package com.local.android.teleasistenciaticplus;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.lib.networking.Networking;
import com.local.android.teleasistenciaticplus.modelo.Constants;


public class actLoadingScreen extends ActionBarActivity implements Constants{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Se muestra la pantalla de carga en base a la constante SPLASH_SCREEN
        //el programa entra por la clase Hook, así que la inicialización general
        //no depende de esta pantalla de inicio

        if ( Constants.SPLASH_SCREEN == true ) {
            setContentView(R.layout.layout_loadingscreen);
        } else {
            Intent intent = new Intent(this, actMain.class);
            startActivity(intent);
        }
    }
}