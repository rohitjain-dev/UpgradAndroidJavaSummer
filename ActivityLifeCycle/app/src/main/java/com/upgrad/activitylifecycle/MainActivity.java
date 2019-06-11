package com.upgrad.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "Upgrad";

    //oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate is running");
    }

     //onstart
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart is running");
    }


    //onresume
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume is running");
    }


    //onrestart
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart is running");
    }

    //onpause
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause is running");
    }

    //onstop

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop is running");
    }


    //ondestroy

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy is running");
    }
}
