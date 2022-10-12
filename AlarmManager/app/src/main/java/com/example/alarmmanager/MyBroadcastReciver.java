package com.example.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;

    public void onReceive(Context context , Intent intent){
        mp=MediaPlayer.create(context, R.id.button);

        mp.start();

        Toast.makeText(context,"alarm",Toast.LENGTH_LONG).show();
    }

}
