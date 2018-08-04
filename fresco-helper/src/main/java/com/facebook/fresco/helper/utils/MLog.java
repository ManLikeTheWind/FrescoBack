package com.facebook.fresco.helper.utils;

import android.util.Log;

/**
 * <br>package: com.dxtest.fresco_manager.utils  MLog
 * <br>.author: dongxiang
 * <br>...date: 2018/8/3  11:14
 * <br>.descrp:
 * <br>..using:
 * <br>.e-mail:dongxiang_android_sdk@aliyun.com
 */

public class MLog {
    private static final String TAG = MLog.class.getSimpleName();
    public static void e  (String content){
        Log.e(TAG, content);
        return ;
    }    public static void i(String content){
        Log.i(TAG, content);
        return ;
    }


}
