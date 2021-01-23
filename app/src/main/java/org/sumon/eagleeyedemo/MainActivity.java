package org.sumon.eagleeyedemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.sumon.eagleeye.EagleEye;
import org.sumon.eagleeye.OnChangeConnectivityListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EagleEye.getStatus(this, new OnChangeConnectivityListener() {
            @Override
            public void onChanged(boolean status) {
                Log.d(TAG, "onChanged status: " + status);
                TextView text = findViewById(R.id.text);
                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    }
                });
            }
        });
    }
}