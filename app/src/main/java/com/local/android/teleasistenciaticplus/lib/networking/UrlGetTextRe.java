package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.SystemClock;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by FESEJU on 17/02/2015.
 */
public class UrlGetTextRe {

    private String url;
    private String text;

    public UrlGetTextRe(String url) {
        this.url = url;
        getOnlineUrlLoader();
    }

    public String getText() {
        SystemClock.sleep(1000);
        return this.text;
    }

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
     * Método necesario para llamarlo en un thread
     */

    public void getOnlineUrlLoader() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                UrlGetTextRe.this.text = getOnlineUrl();
            }

        }).start();

    }
}
