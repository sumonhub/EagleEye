package org.sumon.eagleeye;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class EagleEyeObserver extends BroadcastReceiver {
    private static final String TAG = "ConnectivityReceiver";
    private static OnChangeConnectivityListener onChangeConnectivity;

    public static void setConnectivityListener(OnChangeConnectivityListener connectivity) {
        onChangeConnectivity = connectivity;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        Log.v(TAG, "onReceiveAction = " + intent.getAction());
        if (intent.getExtras() != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert cm != null;
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

            onChangeConnectivity.onChanged(isConnected);

        }
    }
}