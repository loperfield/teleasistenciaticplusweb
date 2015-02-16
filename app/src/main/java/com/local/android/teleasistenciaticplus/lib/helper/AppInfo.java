package com.local.android.teleasistenciaticplus.lib.helper;

import android.content.Context;
import android.content.pm.PackageManager;

import com.local.android.teleasistenciaticplus.modelo.GlobalData;

/**
 * Created by FESEJU on 13/02/2015.
 * Devolverá valores de configuración de la aplicación como la versión
 */
public class AppInfo
{
    /**
     * getAppVersion: devuelve el nombre de la versión recogido en el AndroidManifest
     */
    public static String getAppVersion() {
        Context miContext = GlobalData.getAppContext();

        try
        {
            String app_ver = miContext.getPackageManager().getPackageInfo(miContext.getPackageName(), 0).versionName;
            return app_ver;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            AppLog.e("AppInfo.getAppVersion: ", e.getMessage());
            return null;
        }
    }
}
