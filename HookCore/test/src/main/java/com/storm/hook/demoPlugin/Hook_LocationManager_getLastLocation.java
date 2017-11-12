package com.storm.hook.demoPlugin;

import android.location.LocationProvider;
import android.util.Log;

/**
 * Created by harold on 17-11-1.
 */

public class Hook_LocationManager_getLastLocation {

        public static String className = "android.location.LocationManager";
        public static String methodName = "getLastKnownLocation";
        public static String methodSig = "(Ljava/lang/String;)Landroid/location/Location;";
        public static boolean hook(LocationProvider p) {
            Log.w("YAHFA", "getLastKnownLocation hooked");
            return origin(p);
        }

        public static boolean origin(LocationProvider p) {
            Log.w("YAHFA", "String.startsWith() should not be here");
            return false;

    }
}
