package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.Socket;

/**
 * Created by FESEJU on 20/02/2015.
 */

public class HttpGet extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String line;
        Socket socket = null;
        String data = "";

        socket = new Socket(params[0],80);
        PrintWriter pw = new PrintWriter( new OutputStreamWriter( socket.getOutputStream() ), true);
        pw.println(params[0]);

        data = socket.getInputStream());


    }
}