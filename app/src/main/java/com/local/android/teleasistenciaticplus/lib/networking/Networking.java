package com.local.android.teleasistenciaticplus.lib.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.local.android.teleasistenciaticplus.modelo.Constants;
import com.local.android.teleasistenciaticplus.modelo.GlobalData;

public class Networking {

    /**
     * F8 sirve para activar el emulador
     *
     * @return si existe conexión o no
     */
    public static boolean isOnline() {
        Context mContext = GlobalData.getAppContext();

        try {
            ConnectivityManager cm =
                    (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null &&
                    activeNetwork.isAvailable() &&
                    activeNetwork.isConnected();
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Crea la dirección completa del servidor
     *
     * @return devuelve la cadena completamente formada
     */
    public static String getFullServerAdress() {
        return Constants.SERVER_PROTOCOL + Constants.SERVER_IP + "/" + Constants.SERVER_FILE;
    }
}

   /*
    public static boolean isOnline()
    {
        Context mContext = GlobalData.getAppContext();

        try
        {
            ConnectivityManager cm = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        }
        catch (Exception e)
        {
            return false;
        }
    }*/

    /*
    public static boolean checkServerOnline(String url) {

        boolean serverOnline


    }*/

    /*
    public static boolean isHostReachable(String serverAddress, int serverTCPport, int timeoutMS){
        boolean connected = false;
        Socket socket;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(serverAddress, serverTCPport);
            socket.connect(socketAddress, timeoutMS);
            if (socket.isConnected()) {
                connected = true;
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket = null;
        }
        return connected;
    }
    */

    /* Ejecutar en un thread */
    /*
    static public boolean isURLReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            try {
                URL url = new URL("http://192.168.1.13");   // Change to "http://google.com" for www  test.
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setConnectTimeout(10 * 1000);          // 10 s.
                urlc.connect();
                if (urlc.getResponseCode() == 200) {        // 200 = "OK" code (http connection is fine).
                    Log.wtf("Connection", "Success !");
                    return true;
                } else {
                    return false;
                }
            } catch (MalformedURLException e1) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
    */

    /*
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
    */

    /*
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
    */
