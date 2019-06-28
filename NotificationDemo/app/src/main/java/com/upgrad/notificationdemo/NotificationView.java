package com.upgrad.notificationdemo;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NotificationView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);

        TextView textView = (TextView) findViewById(R.id.textView);

        String message = getIntent().getStringExtra("message");

        textView.setText(message);
    }
}
