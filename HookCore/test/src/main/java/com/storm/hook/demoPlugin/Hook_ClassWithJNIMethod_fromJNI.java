package com.storm.hook.demoPlugin;

import android.util.Log;

/**
 * Created by lrk on 5/4/17.
 */

public class Hook_ClassWithJNIMethod_fromJNI {
    public static String className = "com.example.stormhooksample.ClassWithJNIMethod";
    public static String methodName = "fromJNI";
    public static String methodSig = "()Ljava/lang/String;";

    // calling origin method is no longer available for JNI methods
    public static String hook() {
        Log.w("Hook", "calling fromJNI");
        return "1234";
    }
}
