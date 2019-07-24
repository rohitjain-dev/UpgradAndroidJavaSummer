package com.upgrad.crashme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        Button  button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long futuretime = System.currentTimeMillis() + 10000;

                while (System.currentTimeMillis()<futuretime){
                    synchronized (this){
                        try{
                            wait(futuretime-System.currentTimeMillis());
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }

                textView.setText("Button Clicked");
            }
        });

    }
}
