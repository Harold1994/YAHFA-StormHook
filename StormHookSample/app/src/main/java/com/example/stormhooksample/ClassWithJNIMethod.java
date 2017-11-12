package com.example.stormhooksample;

/**
 * Created by lrk on 5/4/17.
 */

public class ClassWithJNIMethod {
    static {
        System.loadLibrary("hello");
    }

    public native static String fromJNI();
}
