package com.local.android.teleasistenciaticplus;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.local.android.teleasistenciaticplus.lib.helper.AlertDialogShow;
import com.local.android.teleasistenciaticplus.lib.helper.AppInfo;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.lib.helper.TipoDialogo;
import com.local.android.teleasistenciaticplus.lib.networking.HttpUrlTextRead;
import com.local.android.teleasistenciaticplus.lib.networking.Networking;
import com.local.android.teleasistenciaticplus.modelo.Constants;

public class actMainDebug extends ActionBarActivity
                            implements AlertDialogShow.NoticeDialogListener {

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

        if (android.os.Build.VERSION.SDK_INT >= 16) {
            // Memoria usada (Solo API > 16 )
            TextView usedMemoryText = (TextView) findViewById(R.id.debug_used_memory);
            Long memoriaUsada = AppInfo.getUsedMemory();
            Long memoriaTotal = AppInfo.getTotalMemory();
            usedMemoryText.setText("Usada: " + String.valueOf(memoriaUsada) + " mb/ " + "Total: " + String.valueOf(memoriaTotal) + "mb");

            ProgressBar usedMemoryBar = (ProgressBar) findViewById(R.id.debug_progress_bar_used_memory);
        /* Escalamos a 100 como referencia para la barra de progreso */
            usedMemoryBar.setMax(100);
            usedMemoryBar.setProgress((int) ((memoriaUsada * 100.0f) / memoriaTotal));
        }


        //Texto de la dirección de servidor
        TextView serverAddress = (TextView) findViewById(R.id.edit_server_adress);
        serverAddress.setText(Constants.SERVER_URL_FILE);
    }

    /**
     * Menus de la actividad
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
     * Pulsado el botón de comprobación online
     */
    public void main_debug_button_check_online(View view) {
        ////////////////////////////////////////////////////
        // Comprobación de estado online servidor
        ////////////////////////////////////////////////////

        //Interfaz
        TextView serverAddress = (TextView) findViewById(R.id.edit_server_adress);

        String url = serverAddress.getText().toString(); //primero usamos la introducida en la caja de texto

        if (url.length() == 0) {  //Si la cadena está vacia usamos la url por defecto
            serverAddress.setText(Constants.SERVER_URL_FILE);
        }

        Boolean isNetworkAvailable = Networking.isConnectedToInternet();

        showConnectionToInternetInTextBackground(serverAddress); //Indicamos el estado online mediante color rojo o verde

        //Comprobación de el servidor está disponible (se hace mediante la lectura de un fichero en el mismo)
        //y sólo se realiza si existe conexión de internet

        if (isNetworkAvailable) {

            String textRead = null;

            try {
                HttpUrlTextRead miUrl = new HttpUrlTextRead(url);
                textRead = miUrl.getText();
            } catch (Exception e) {
                AppLog.d("actMainDebug", "Error leyendo el archivo");
            }

            String resultado;

            if (textRead == null) {
                resultado = getResources().getString(R.string.ERROR);
                AppLog.i("actMainDebug", "Error accediendo a la dirección:\"" + url + "\"");
            } else {
                resultado = getResources().getString(R.string.CORRECTO);
                AppLog.i("actMainDebug", textRead);
            }

            /////////
            //Generación de alerta en pantalla con el resultado de la conexión
            /////////
            AlertDialogShow showConnectionResult = new AlertDialogShow();
            showConnectionResult.setTitulo( getResources().getString(R.string.check_internet_conn_title) );
            if (resultado.equals( getResources().getString(R.string.ERROR)  )) {
                showConnectionResult.setMessage(getResources().getString(R.string.check_internet_conn_error));
                showConnectionResult.setTipoDialogo(TipoDialogo.TWO);
            }else {
                showConnectionResult.setMessage(getResources().getString(R.string.check_internet_conn_ok));
                showConnectionResult.setTipoDialogo(TipoDialogo.ONE);
            }

            showConnectionResult.setLabelCancel(getResources().getString(R.string.close_window));
            showConnectionResult.setLabelOk(getResources().getString(R.string.check_internet_conn_retry));
            showConnectionResult.setLabelNeutral(getResources().getString(R.string.close_window));

            showConnectionResult.show(getFragmentManager(), "internetAccessTAG");
        }
    }

    //Implementamos las acciones de cada botón de la alerta
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        //Reintentar la conexión

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        //Cerrar la ventana de la alerta
        finish();
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog) {
        //no se implementa
    }



    /**
     * Mostramos si hay conexión a internet en el color de fondo de la caja de texto
     *
     * @param serverAddress
     */

    private void showConnectionToInternetInTextBackground(TextView serverAddress) {
        //Comprobación de que exista conexión de datos en el teléfono
        final Boolean isNetworkAvailable = Networking.isConnectedToInternet();

        if (isNetworkAvailable) {
            //Server online fondo verde
            serverAddress.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            //Server offline fondo rojo
            serverAddress.setBackgroundColor(getResources().getColor(R.color.red));
        }
    }
} // Fin actividadMainDebug

