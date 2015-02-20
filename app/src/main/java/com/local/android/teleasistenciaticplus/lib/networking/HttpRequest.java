package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.AsyncTask;
import android.os.SystemClock;

import com.local.android.teleasistenciaticplus.modelo.Constants;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

/**
 * Created by FESEJU on 17/02/2015.
 * El objetivo de esta clase es obtener el texto de cualquier fichero que aparezca en un servidor http
 * @input url contiene la ruta completa que intentará leer la clase
 */
public class HttpRequest implements Constants {

    private String url;

    public HttpRequest(String url) {
        this.url = url;
    }

    public String httpGet() throws ExecutionException, InterruptedException {
        HttpGet miHttpGet = new HttpGet();
        return miHttpGet.execute(url).get();
    }
} //Fin clase HttpRequests