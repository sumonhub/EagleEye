package org.sumon.eagleeye;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import java.util.Objects;

public class EagleEyeApp extends Application {

    private static final String TAG = "EagleEyeApp";

    @Override
    public void onCreate() {
        super.onCreate();
        registerConnectivityReceiver();
    }

    // register here your filter
    private void registerConnectivityReceiver() {
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(EagleEyeObserver.getInstance(), filter);
        } catch (Exception e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
        }
    }

}
