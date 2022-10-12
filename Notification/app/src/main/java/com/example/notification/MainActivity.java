package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "My channel";

    private static final int NOTIFICATION_ID = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.download, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap lageIcon = bitmapDrawable.getBitmap();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setLargeIcon(lageIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("new massage")
                    .setSubText("new massage from Raman")
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "new Channel", NotificationManager.IMPORTANCE_DEFAULT));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(lageIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("new massage")
                    .setSubText("new massage from Raman")
                    .build();
        }

        notificationManager.notify(NOTIFICATION_ID, notification);


    }
}