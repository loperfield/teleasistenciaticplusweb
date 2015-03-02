package com.local.android.teleasistenciaticplus.modelo;

import android.app.Application;

import com.local.android.teleasistenciaticplus.lib.Phone.PhoneData;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;

/**
 * Created by FESEJU on 11/02/2015.
 * - HOOK que se ejecutara en primer lugar, incluso antes que la actividad principal.
 * Lo usaremos para operaciones iniciales, como por ejemplo guardar el contexto de la aplicación
 *
 */

public class Hook extends Application {

    /**
     * Almacenamos el contexto de la aplicación
     */
    public void onCreate(){

        super.onCreate();

        GlobalData.setContext( getApplicationContext() );
        GlobalData.setPhoneNumber(new PhoneData().getNumber());
        AppLog.v("Hook.class", "Hook de aplicación"); //:LOG:
    }

}