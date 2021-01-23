package org.sumon.eagleeyedemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.sumon.eagleeye.EagleEye;
import org.sumon.eagleeye.OnChangeConnectivityListener;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EagleEye.getStatus(this, new OnChangeConnectivityListener() {
            @Override
            public void onChanged(boolean status) {
                Log.d(TAG, "onChanged status: " + status);
            }
        });
    }
}