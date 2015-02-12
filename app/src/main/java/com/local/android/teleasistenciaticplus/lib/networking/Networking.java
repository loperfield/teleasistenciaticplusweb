package com.local.android.teleasistenciaticplus.lib.networking;

import android.os.Build;
import android.util.Log;

import com.local.android.teleasistenciaticplus.lib.helper.AppLog;

import java.io.BufferedReader;
import java.io.IOException;
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

}
