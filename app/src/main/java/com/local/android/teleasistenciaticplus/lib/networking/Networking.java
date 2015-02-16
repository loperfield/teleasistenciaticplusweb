package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.Build;
import android.util.Log;

import com.local.android.teleasistenciaticplus.R;
import com.local.android.teleasistenciaticplus.lib.helper.AppLog;
import com.local.android.teleasistenciaticplus.modelo.Constants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by FESEJU on 11/02/2015.
 */
public class Networking {

    public static boolean pingAddress(String url) {
        /////////////////////////////
        int count = 0;
        String str = "";

        try {

            Process process = null;

            if (Build.VERSION.SDK_INT <= 16) {
                // shiny APIS
                process = Runtime.getRuntime().exec(
                        "/system/bin/ping -w 1 -c 1 " + url);
            } else {

                process = new ProcessBuilder()
                        .command("/system/bin/ping", url)
                        .redirectErrorStream(true)
                        .start();
            }


            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));

            StringBuffer output = new StringBuffer();
            String temp;

            while ((temp = reader.readLine()) != null)//.read(buffer)) > 0)
            {
                output.append(temp);
                count++;
            }

            reader.close();


            if (count > 0)
                str = output.toString();

            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        AppLog.i("PING Count", "" + count);
        AppLog.i("PING String", str);
/////////////////////////////
        return true;
    }

    /**
     * Comprobará si el servidor está respondiendo mediante el intento de lectura de un archivo
     * @param url url completamente formada http://127.0.0.1/file.txt
     * @return
     */

    public static boolean ServerOnline(String url) throws IOException {

        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httppost = new HttpGet(url);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity ht = response.getEntity();

        BufferedHttpEntity buf = new BufferedHttpEntity(ht);

        InputStream is = buf.getContent();

        BufferedReader r = new BufferedReader(new InputStreamReader(is));

        //StringBuilder total = new StringBuilder();
        String line;

        int fileSize = 0;
        while ((line = r.readLine()) != null) {
            AppLog.i("Networking:", line);
            fileSize++;
            //total.append(line + "\n");
        }

        if ( fileSize > 0 ) {
            return true; //ha podido leer el archivo, el server esta online
        } else {
            return false; //el server está offline
        }
    }

    /**
     * Check server online
     * @param url
     * @return
     */
    public static boolean checkServerOnline(String url) {

        boolean serverOnline;

            if ( Networking.checkServerOnline(url) ) {
                serverOnline = true;
            } else {
                serverOnline = false;
            }

        if ( serverOnline == true) {
            return ( true );
        } else {
            return ( false );
        }

    }


    /**
     * Crea la dirección completa del servidor
     * @return devuelve la cadena completamente formada
     */
    public static String getFullServerAdress() {
        return Constants.SERVER_PROTOCOL + Constants.SERVER_IP + "/" + Constants.SERVER_FILE;
    }

}
