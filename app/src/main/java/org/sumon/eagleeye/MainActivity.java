package org.sumon.eagleeye;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*EagleEyeObserver.setConnectivityListener(new OnChangeConnectivityListener() {
            @Override
            public void onChanged(boolean status) {
                Log.d(TAG, "onChanged: main = " + status);
                TextView t = findViewById(R.id.textView);
                t.setText("" + status);
                Toast.makeText(MainActivity.this, "" + status, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}