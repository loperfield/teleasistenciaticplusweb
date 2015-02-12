package com.local.android.teleasistenciaticplus.modelo;

import android.app.Application;
import android.content.Context;

/**
 * Created by FESEJU on 11/02/2015.
 * - Se ejecutara en primer lugar, incluso antes que la actividad principal
 * - Es un Singleton que guardará el contexto de la aplicación allá cuando sea necesario
 * - Al guardar el Contexto (BIG) de la aplicación mediante getApplicationContext()
 * no tendremos el problema de memoryLeak
 *
 * @return context; Devuelve el Contexto (BIG) de la aplicación
 */

public class GlobalData extends Application {

    //Contexto de la aplicación
    private static Context context;

    //Guardamos el contexto de la aplicación
    public static void setContext(Context context) {
        GlobalData.context = context;
    }

    //Metodo que devuelve el contexto de la aplicación
    //A efectos de modelo MVP, sólo el presentador debería acceder a ella
    public static Context getAppContext() {
        return GlobalData.context;
    }
}