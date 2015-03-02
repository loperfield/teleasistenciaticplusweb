package com.local.android.teleasistenciaticplus.lib.networking;

import com.local.android.teleasistenciaticplus.lib.Phone.PhoneData;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.modelo.Constants;

/**
 * Created by GAMO1J on 02/03/2015.
 * Clase genérica para realizar operaciones contra el servidor
 */
public class ServerOperations {

    //Método de comprobación del estado del servidor (online/offline | true/false)
    public static boolean serverIsOnline() {
        String url = Constants.SERVER_URL_FILE;
        String textRead = null;

        try {
            HttpUrlTextRead miUrl = new HttpUrlTextRead(url);
                textRead = miUrl.getText();
        } catch (Exception e) {
                AppLog.d("ServerOperations -> ", "Error leyendo el archivo");
        }


        if ( textRead.equals("true") ) {
            AppLog.i("ServerOperations -> ", textRead);
            return true;
        } else {
            AppLog.i("ServerOperations -> ", "Error accediendo a la dirección:\"" + url + "\"");
            return false;
        }
    }

    //Comprobación de usuario registrado en el sistema
    public static boolean isRegisteredInServer() {
        //recuperamos el número del terminal
        String phoneNumber = new PhoneData().getNumber();

        //TODO: conectamos al servidor vía /phone/check/ y recuperamos la respuesta

        //TODO: Si el server nos devuelve el string "true" el usuario está registrado

        return true;
    }

    /*
    public boolean setAlarm(Alarma miAlarma) {

    }*/
}

