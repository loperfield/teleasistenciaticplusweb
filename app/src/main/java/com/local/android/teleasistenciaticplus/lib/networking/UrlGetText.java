package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.SystemClock;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by FESEJU on 17/02/2015.
 */
public class UrlGetText {

    public static String getOnlineUrl(String urlString) {
        URLConnection feedUrl;
        try {
            feedUrl = new URL(urlString).openConnection();
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

    public static void getOnlineUrlLoader() {

        new Thread(new Runnable() {

            public void run() {
                String str = getOnlineUrl( "http://japones.info/index.ht" );
                SystemClock.sleep(2000);
                //Log.e(">>", str);
            }

        }).start();

    }
}
