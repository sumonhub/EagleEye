package org.sumon.eagleeye;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class EagleEye {

    public static void getStatus(Context context, final OnChangeConnectivityListener onChangeConnectivityListener) {
        EagleEyeObserver.getInstance().getLiveData().observe((LifecycleOwner) context, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                onChangeConnectivityListener.onChanged(aBoolean);
            }
        });
    }
}
