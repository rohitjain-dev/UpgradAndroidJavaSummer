package com.upgrad.delaymainui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView textView = findViewById(R.id.textView);
            textView.setText("Button Clicked");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        long futuretime = System.currentTimeMillis() + 10000;

                        while (System.currentTimeMillis()<futuretime){
                            synchronized (this){
                                try{

                                    wait(futuretime - System.currentTimeMillis());
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        handler.sendEmptyMessage(0);
                    }
                };
                Thread mythread = new Thread(r);
                mythread.start();
            }
        });
    }
}
