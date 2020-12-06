package org.sumon.eagleeye;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import java.util.Objects;

public class App extends Application {

    private static final String TAG = "EagleEyeApplication";
    private EagleEyeObserver eagleEyeObserver;

    private EagleEyeObserver getEagleEyeObserver() {
        if (eagleEyeObserver == null)
            eagleEyeObserver = new EagleEyeObserver();
        return eagleEyeObserver;
    }

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
            registerReceiver(getEagleEyeObserver(), filter);
        } catch (Exception e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
        }
    }

}
