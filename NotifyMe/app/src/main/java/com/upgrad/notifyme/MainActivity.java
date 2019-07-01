package com.upgrad.notifyme;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationUtills mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNotification = new NotificationUtills(this);
        Button notifyButton = (Button) findViewById(R.id.button);

        notifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder builder = mNotification.getHogwardsChannelNOtification("HoCrux","Harry the new hocrux is in the locat");
                mNotification.getManager().notify(101,builder.build());
            }
        });
    }


}
