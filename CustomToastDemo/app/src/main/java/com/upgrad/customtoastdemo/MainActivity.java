package com.upgrad.customtoastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create an Instance of Layout Inflatre
                LayoutInflater layoutInflater = getLayoutInflater();

                //get a view from the layout
                View layout = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast_root));

                //Call The Toast Call

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                //show this in center of the screen
                //toast.setGravity(Gravity.CENTER_VERTICAL,0,0);

                //show the custom
                toast.setView(layout);
                toast.show();


            }
        });
    }
}
