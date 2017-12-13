package com.yann.b2b.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.yann.b2b.BuildConfig;

/**
 * Created by yayun.xia on 2017/12/4.
 */

public class MyApp extends Application {

    public static final String APP_NAME = "";
    public static boolean isDebug;

    @Override
    public void onCreate() {
        super.onCreate();

        isDebug = BuildConfig.DEBUG;
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
