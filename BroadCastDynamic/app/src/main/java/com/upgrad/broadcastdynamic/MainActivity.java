package com.upgrad.broadcastdynamic;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyBrodcastReciver brodcastReciver = new MyBrodcastReciver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(brodcastReciver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(brodcastReciver);
    }
}
