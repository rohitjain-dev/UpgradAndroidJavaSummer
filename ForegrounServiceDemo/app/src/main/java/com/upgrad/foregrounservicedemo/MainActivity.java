package com.upgrad.foregrounservicedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button startButton,stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text_input);

        final String input = editText.getText().toString();

        startButton = findViewById(R.id.buttonStart);

        stopButton = findViewById(R.id.buttonStop);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceintent = new Intent(getApplicationContext(),ForegroundService.class);
                serviceintent.putExtra("inputExtra",input);
                ContextCompat.startForegroundService(getApplicationContext(),serviceintent);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceintent = new Intent(getApplicationContext(),ForegroundService.class);
                stopService(serviceintent);
            }
        });
    }
}
