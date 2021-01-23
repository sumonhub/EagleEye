package org.sumon.eagleeye;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EagleEyeObserver extends BroadcastReceiver {
    public static EagleEyeObserver instance;
    final String TAG = "EagleEyeApp";
    MutableLiveData<Boolean> liveData = new MutableLiveData<>();

    public static EagleEyeObserver getInstance() {
        if (instance == null) {
            instance = new EagleEyeObserver();
        }
        return instance;
    }

    LiveData<Boolean> getLiveData() {
        return liveData;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        liveData.setValue(isConnected && isInternetAvailable());
    }

    public boolean isInternetAvailable() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> result = executor.submit(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                InetAddress address = InetAddress.getByName("www.google.com");
                return !address.toString().equals("");
            }
        });

        try {
            return result.get();
        } catch (Exception exception) {
            Log.e(TAG, exception.getMessage());
            return false;
        }
    }
}