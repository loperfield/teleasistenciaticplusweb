package com.local.android.teleasistenciaticplus.lib.Phone;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.local.android.teleasistenciaticplus.modelo.GlobalData;

/**
 * Created by GAMO1J on 02/03/2015.
 * Clase para recuperar los datos del terminal
 *
 * @param: phoneNumber: número de teléfono
 */
public class PhoneData {

    private Context mContext; //Contexto privado que saco de l a global de la aplicación
    private TelephonyManager tm; //

    //Datos importantes del teléfono
    private String phoneNumber;

    public PhoneData() {
        mContext = GlobalData.getAppContext();
        tm = (TelephonyManager)mContext.getSystemService(Context.TELEPHONY_SERVICE);
        phoneNumber = tm.getLine1Number();
    }

    //Getters
    public String getNumber() {
        return phoneNumber;
        //return true;
    }
}
