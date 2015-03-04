package com.local.android.teleasistenciaticplus.lib.networking;

import com.local.android.teleasistenciaticplus.lib.cifrado.Cifrado;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.modelo.Constants;
import com.local.android.teleasistenciaticplus.modelo.GlobalData;

/**
 * Created by GAMO1J on 02/03/2015.
 * Clase genérica para realizar operaciones contra el servidor
 */
public class ServerOperations {

    //Método de comprobación del estado del servidor (online/offline | true/false)
    public static boolean serverIsOnline() {
        String url = Constants.SERVER_URL_FILE;
        String textRead = "";

        try {
            HttpUrlTextRead miUrl = new HttpUrlTextRead(url);
                textRead = miUrl.getText();
        } catch (Exception e) {
                AppLog.d("ServerOperations -> ", "Error leyendo el archivo");
        }

        AppLog.i("ServerOperations -> ", "textRead: " + textRead);
        if (textRead != null) {
            if (textRead.equals("true")) {
                AppLog.i("ServerOperations -> ", textRead);
                return true;
            } else {
                AppLog.i("ServerOperations -> ", "Error accediendo a la dirección:\"" + url + "\"");
                return false;
            }
        }
        return false;
    }

    //Comprobación de usuario registrado en el sistema
    public static boolean isRegisteredInServer() {

        //recuperamos el número del terminal
        String phoneNumber = GlobalData.getPhoneNumber();
        AppLog.i("ServerOperations -> ", "Número de teléfono: " + phoneNumber);

        //Encriptamos el número de teléfono
        if( phoneNumber.isEmpty() ) {
            AppLog.i("ServerOperations -> ", "Número de teléfono: VACIO");
            return false;
        }

        //Llamamos a la encriptación
        String cifrado = "";
        try {
            cifrado = new Cifrado().cifrar(phoneNumber);
        } catch (Exception e) {
            AppLog.e("ServerOperations -->", "Problema de cifrado: " + phoneNumber, e);
        }

        //conectamos al servidor vía /phone/check/ y recuperamos la respuesta
        String ConstUrlPhoneCheck = Constants.SERVER_URL + Constants.CONTROLLER_CHECK_PHONE + cifrado;
        String textRead = "";
        try {
            HttpUrlTextRead miUrl = new HttpUrlTextRead(ConstUrlPhoneCheck);
            textRead = miUrl.getText();
        } catch (Exception e) {
            AppLog.d("ServerOperations -> ", "Error de conexión??");
        }

        //Si el server nos devuelve el string "true" el usuario está registrado
        if (textRead != null) {
            if (textRead.equals("true")) {
                AppLog.i("ServerOperations -> ", textRead);
                return true;
            } else {
                AppLog.i("ServerOperations -> ", "Error accediendo a la dirección:\"" + ConstUrlPhoneCheck + "\"");
                return false;
            }
        }
        return false;
    }

    //Solicitar el nombre del usuario
    public static String retrieveUserName () {

        //Recuperamos el número de teléfono
        String pn = GlobalData.getPhoneNumber();

        //Llamamos a la encriptación
        String cifrado = "";
        try {
            cifrado = new Cifrado().cifrar(pn);
        } catch (Exception e) {
            AppLog.e("ServerOperations -->", "Problema de cifrado: " + pn, e);
        }

        //conectamos al servidor vía /phoneuser/name/ y recuperamos la respuesta
        String ConstUrlPhoneUserName = Constants.SERVER_URL + Constants.CONTROLLER_USER_NAME + cifrado;
        String textRead = "";
        try {
            HttpUrlTextRead miUrl = new HttpUrlTextRead(ConstUrlPhoneUserName);
            textRead = miUrl.getText();
        } catch (Exception e) {
            AppLog.d("ServerOperations -> ", "Error de conexión??");
        }
        if (textRead != null) {
            if ( textRead.length() != 0 ) {
                AppLog.i("ServerOperations -> ", textRead);
                return textRead;
            } else {
                AppLog.i("ServerOperations -> ", "Error recuperando el nombre del usuario:\"" + ConstUrlPhoneUserName + "\"");
                return "unknown user";
            }
        }
        return "unknown user";
    }




    //TODO: implementar aviso
    /*
    public boolean setAlarm(Alarma miAlarma) {

    }*/
}

