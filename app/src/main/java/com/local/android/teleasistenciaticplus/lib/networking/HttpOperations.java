package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.SystemClock;

import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by FESEJU on 17/02/2015.
 * El objetivo de esta clase es obtener el texto de cualquier fichero que aparezca en un servidor http
 * @input url contiene la ruta completa que intentará leer la clase
 * @output text devolverá el texto contenido en el fichero leido o null
 */
public class HttpOperations implements Constants {

    private String url; //input
    private String text; //output

    /**
     * Constructor
     * @param url
     */
    public HttpOperations(String url) {
        this.url = url;
        getOnlineUrlLoader();
    }

    /**
     * Getter
     * @return el texto que contiene la url leida o null
     */
    public String getText() {
        SystemClock.sleep(Constants.HTTP_OPERATION_DELAY);
        return this.text;
    }

    /**
     * El métido que abre una conexión de lectura a la URL y guarda el contenido en text
     * @return String con el texto leido o null
     */
    public String getOnlineUrl() {
        URLConnection feedUrl;
        try {
            feedUrl = new URL(this.url).openConnection();
            InputStream is = feedUrl.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "");
            }
            is.close();

            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * La operación necesita ser llamada en un thread y la llamada la realiza
     * este metodo. Es necesario usar después un delay para que el valor de text
     * se propague realmente al text de esta clase. Es la máquina virtual de android
     * la que decide cuando ejecutar el thread.
     */
    public void getOnlineUrlLoader() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpOperations.this.text = getOnlineUrl();
            }

        }).start();

    }
} //Fin clase HttpOperations