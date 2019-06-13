package com.upgrad.passdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String name = getIntent().getStringExtra("username");
        TextView txv1 = (TextView) findViewById(R.id.txv1);
        txv1.setText(name);

    }
}
