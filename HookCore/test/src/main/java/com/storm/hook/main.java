package com.storm.hook;

import android.util.Log;

import dalvik.system.PathClassLoader;
import lab.galaxy.yahfa.HookMain;

/**
 * Created by Administrator on 2017/8/29.
 */

public class main {


    //private static String dalvik_oldPath="/data/local/tmp/libdalvikhook_native.so";
    //private static String art_oldPath="/data/local/tmp/libarthook_native.so";



    public static String TAG="storm";

    public static void Entry(PathClassLoader PathClassLoader, String pkgName, boolean Inject_flag){
        Log.d(TAG,"Inject dex entry is called");
        //Add PathClassLoader so path or use System.load() instead of System.loadLibrary
        OperateDexClassLoader.AddNativeLibraryDirectory(PathClassLoader);
        HookMain.doHookDefault();
//        HookManager.getDefault().applyHooks(HookMethod.class);
//        if(Runtime.isArt()){
//
//            ArtHook.flag=Inject_flag;
//            HookManager.getDefault().applyHooks(HookMethod.class);
//            }
//        }
//        else{
//            Runtime.isArt=false;
//            DalvikHookManager.hook(Inject_SaveOrigProto.class);
//        }

    }

}
