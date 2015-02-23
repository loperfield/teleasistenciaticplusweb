package com.local.android.teleasistenciaticplus.lib.networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.local.android.teleasistenciaticplus.modelo.GlobalData;

public class Networking {

    /**
     * F8 sirve para activar los datos en el emulador
     * @return si existe conexión o no
     */
    public static boolean isConnectedToInternet() {
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
}
