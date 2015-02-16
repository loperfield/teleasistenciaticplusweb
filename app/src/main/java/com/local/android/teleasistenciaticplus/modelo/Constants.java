package com.local.android.teleasistenciaticplus.modelo;

/**
 * Created by FESEJU on 11/02/2015.
 * Interfaz de constantes generales de la aplicación
 */

public interface Constants {

    ////////////////////////////////////////////////
    // VALORES DE DESARROLLO DE LA APLICACIÓN
    ////////////////////////////////////////////////

        public static final DebugLevel DEBUG_LEVEL = DebugLevel.DEBUG;
        public static final Boolean LOG_TO_FILE = true;
        public static final String DEBUG_LOG_FILE = "teleasistencia.log";

    ////////////////////////////////////////////////
    // MISCELANEA
    ////////////////////////////////////////////////

        public static final long LOADIN_SCREEN_TIME = 3000;

    ////////////////////////////////////////////////
    // SERVIDOR TELEASISTENCIA
    ////////////////////////////////////////////////

        public static final String SERVER_PROTOCOL = "http://";
        public static final String SERVER_IP = "127.0.0.1";

}
