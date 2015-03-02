package com.local.android.teleasistenciaticplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.modelo.Constants;

/**
 *
 * Actividad principal
 * - Primera actividad tras la pantalla inicial de carga
 */

public class actMain extends ActionBarActivity implements Constants {

    //TAG para Log
    final static String TAG = "actMain: ";
    //Botón rojo de alarma principal
    Button tfmRedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        tfmRedButton = (Button) findViewById(R.id.tla_btn);
        tfmRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(getApplicationContext(), R.string.dialer_calling,Toast.LENGTH_SHORT).show();
            AppLog.i(TAG, "Llamando a Teleasistencia.");
            tfmRedButton.setText("CANCELAR AYUDA");
            tfmRedButton.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
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
