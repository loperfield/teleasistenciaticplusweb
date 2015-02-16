package com.local.android.teleasistenciaticplus;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.local.android.teleasistenciaticplus.modelo.Constants;
import com.local.android.teleasistenciaticplus.presentador.Presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * Actividad principal
 * - Primera actividad tras la pantalla inicial de carga
 */

public class actMain extends ActionBarActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    /**
     * Menu de la aplicación principal. En base a la constante de depuración
     * mostraremo o no el menu de depuración
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;

        // Si estamos en modo de depuración
        if ( Constants.DEBUG_LEVEL == DEBUG_LEVEL.DEBUG ) {
            getMenuInflater().inflate(R.menu.menu_act_main, menu);
        } else { //si estamos en modo de producción no mostramos el menu de depuración
            getMenuInflater().inflate(R.menu.menu_act_main_produccion, menu);
        }

        return true;
    }

    /**
     * Menu de la aplicación principal: Pantalla de debug, salida
     * @return
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_actmain_exit_app) {
            finish();
        } else if ( id == R.id.menu_actmain_debug_screen ) {
            Intent intent = new Intent(this, actMainDebug.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
