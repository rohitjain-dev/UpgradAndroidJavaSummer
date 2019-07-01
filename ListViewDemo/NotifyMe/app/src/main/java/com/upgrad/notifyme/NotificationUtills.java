package com.upgrad.notifyme;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;

public class NotificationUtills  extends ContextWrapper {

    private NotificationManager notificationManager;

    public static final String ANDROID_CHANNEL_ID = "hogwartschannel";
    public  static final String ANDROID_CHANNEL_NAME = "HarryPotter";

    public NotificationUtills(Context base) {
        super(base);
        createChannel();
    }


    public void createChannel()
    {
        //create a channel
        NotificationChannel channel = new NotificationChannel(ANDROID_CHANNEL_ID,ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        // behaviour of channel
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        //set the channel
        getManager().createNotificationChannel(channel);
    }

     public NotificationManager getManager() {
        if (notificationManager == null) {
            //setup my notification
            notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notificationManager;
    }

    public Notification.Builder getHogwardsChannelNOtification(String title,String body){
        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText(body)
                .setAutoCancel(true);
    }
}
