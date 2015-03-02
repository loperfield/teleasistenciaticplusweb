package com.local.android.teleasistenciaticplus.lib.filesystem;

import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FESEJU on 12/02/2015.
 * Escritura del log a un fichero físico en android
 */

public class FileOperation implements Constants {

    public static void fileLogWrite(String tag, String msg) {
        {
            //Timestamp
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String currentDateandTime = sdf.format(new Date());

            String text = currentDateandTime + tag + "--> " + msg;

            File logFile = new File(DEBUG_LOG_FILE);
            //Log.i("Creación de fichero", "fichero creado");

            //////////// En el caso que no quisieramos borrar el fichero ///////
            if ( !logFile.exists() ) {
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                //BufferedWriter for performance, true to set append to file flag
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                buf.append(text);
                buf.newLine();
                buf.flush(); //Creo que esto es necesario
                buf.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
