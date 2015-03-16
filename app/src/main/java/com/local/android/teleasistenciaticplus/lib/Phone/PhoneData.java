package com.local.android.teleasistenciaticplus.lib.Phone;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.modelo.GlobalData;

/**
 * Created by GAMO1J on 02/03/2015.
 * Clase para recuperar los datos del terminal
 *
 * @param: phoneNumber: número de teléfono
 */
public class PhoneData {

    private Context mContext; //Contexto privado que saco de la global de la aplicación
    private TelephonyManager tm; //

    //Datos importantes del teléfono
    private String phoneNumber;

    /**
     * Constructor
     */
    public PhoneData() {
        mContext = GlobalData.getAppContext();

        //Recuperamos el número de teléfono
        tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        phoneNumber = "657894456";//tm.getLine1Number();

        if ( phoneNumber.length() == 0) {
            AppLog.e("PhoneData --> ", "Número de teléfono vacío");
        }
        //TODO: ver cómo se puede recuperar el teléfono de una segunda tarjeta
    }

    //Getters
    public String getNumber() {
        return phoneNumber;
        //return true;
    }
}
