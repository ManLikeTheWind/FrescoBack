package com.facebook.demofresco;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.facebook.demofresco.okhttp3.OkHttpNetworkFetcher;
import com.facebook.fresco.helper.Phoenix;
import com.facebook.fresco.helper.config.PhoenixConfig;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;

import java.util.HashSet;
import java.util.Set;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by android_ls on 2017/6/12.
 */

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
//        Phoenix.init(this);

        // LOG过滤标签： RequestLoggingListener
        Set<RequestListener> requestListeners = new HashSet<>();
        requestListeners.add(new RequestLoggingListener());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        ImagePipelineConfig imagePipelineConfig = new PhoenixConfig.Builder(this)
                .setNetworkFetcher(new OkHttpNetworkFetcher(okHttpClient))
                .setRequestListeners(requestListeners)
                .build();

        Phoenix.init(this, imagePipelineConfig); // this-->Context

        regiester();
    }
    
    private void regiester(){
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.e(TAG, "onActivityCreated([activity, savedInstanceState]): "+activity.getClass().getName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.e(TAG, "onActivityStarted([activity]): "+activity.getClass().getName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.e(TAG, "onActivityResumed([activity]): "+activity.getClass().getName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.e(TAG, "onActivityPaused([activity]): "+activity.getClass().getName());

            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.e(TAG, "onActivityStopped([activity]): "+activity.getClass().getName());

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.e(TAG, "onActivitySaveInstanceState([activity, outState]): "+activity.getClass().getName());

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.e(TAG, "onActivityDestroyed([activity]): "+activity.getClass().getName());

            }
        });
    }

}
