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

        public static final long LOADING_SCREEN_TIME = 1000;
        public static final long MEMORY_DIVIDER = 1048576L; //BytestoMegabytes

        /*
        1024 bytes      == 1 kilobyte
        1024 kilobytes  == 1 megabyte

        1024 * 1024     == 1048576*/


    ////////////////////////////////////////////////
    // SERVIDOR TELEASISTENCIA
    ////////////////////////////////////////////////
/*
        public static final String SERVER_PROTOCOL = "http://";
        public static final String SERVER_IP = "127.0.0.1";
        public static final String SERVER_FILE = "onlinecheck.txt";*/

    public static final String SERVER_PROTOCOL = "http://";
    public static final String SERVER_IP = "japones.info";
    public static final String SERVER_FILE = "index.htm";
}
