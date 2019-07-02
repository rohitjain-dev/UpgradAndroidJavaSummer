package com.upgrad.staticbroadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StaticBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       boolean isAirplaneMode = false;
       isAirplaneMode = Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction());
      if (isAirplaneMode){
          Toast.makeText(context,"AirplaneMode on",Toast.LENGTH_LONG).show();
      } else {
          Toast.makeText(context,"Airplane mode off",Toast.LENGTH_LONG).show();
      }

      if (Intent.ACTION_BATTERY_LOW.equals(intent.getAction())){
          Toast.makeText(context,"Battery is low",Toast.LENGTH_LONG).show();
      }
    }
}
