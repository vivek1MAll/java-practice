package com.example.internet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class internetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = CheckInternet.getNetworkInfo(context);
        if (status.equals("connected")) {
            Toast.makeText(context, "the network is connected", Toast.LENGTH_LONG).show();
        } else if (status.equals("disconnected")) {
            Toast.makeText(context, "the network is disconnected ", Toast.LENGTH_LONG).show();
        }
    }
}
