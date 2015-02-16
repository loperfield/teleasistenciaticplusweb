package com.local.android.teleasistenciaticplus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.local.android.teleasistenciaticplus.lib.helper.AppInfo;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.lib.networking.Networking;
import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.io.IOException;


public class actMainDebug extends ActionBarActivity {

    /**
     * Creación de la actividad de depuración
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_debug);

        ////////////////////////////////////////////////////
        // Cálculo de información de la aplicación para depuración
        ////////////////////////////////////////////////////

        // Memoria usada (Solo API > 16 )
        TextView usedMemoryText = (TextView) findViewById(R.id.debug_used_memory);
        Long memoriaUsada = AppInfo.getUsedMemory();
        Long memoriaTotal = AppInfo.getTotalMemory();
        usedMemoryText.setText( "Usada: " + String.valueOf( memoriaUsada ) +" mb/ "+ "Total: " + String.valueOf( memoriaTotal ) + "mb" );

        ProgressBar usedMemoryBar = (ProgressBar) findViewById(R.id.debug_progress_bar_used_memory);
        /* Escalamos a 100 como referencia para la barra de progreso */
        usedMemoryBar.setMax( 100 );
        usedMemoryBar.setProgress( (int)((memoriaUsada * 100.0f) / memoriaTotal) );

        //Texto de la dirección de servidor
        TextView serverAddress = (TextView) findViewById(R.id.edit_server_adress);
        serverAddress.setText( Networking.getFullServerAdress() );

    }

    /**
     * Menus de la actividad
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main_debug, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_act_main_debug_exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void exit_button(View view) {
        finish();
    }

    /**
     * Pulsar el botón de comprobación online
     * @param view
     */
    public void main_debug_button_check_online(View view) {
        ////////////////////////////////////////////////////
        // Comprobación de estado online al servidor
        ////////////////////////////////////////////////////
        TextView serverAddress = (TextView) findViewById(R.id.edit_server_adress);
        serverAddress.setText( Networking.getFullServerAdress() );

        Boolean serverOnline = Networking.checkServerOnline( Networking.getFullServerAdress() );

        if (serverOnline == true) {
            //Server online fondo verde
            serverAddress.setBackgroundColor(getResources().getColor(R.color.green));
            //Server offline fondo rojo
        } else {
            serverAddress.setBackgroundColor(getResources().getColor(R.color.red));
        }


    }
}
