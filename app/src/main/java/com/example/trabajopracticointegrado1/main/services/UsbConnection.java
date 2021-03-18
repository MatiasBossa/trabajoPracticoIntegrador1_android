package com.example.trabajopracticointegrado1.main.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class UsbConnection extends BroadcastReceiver {

    @Override
     public void onReceive(Context context, Intent intent){
        String intentString = intent.getAction();
        String phone = "911";
        boolean loading = intentString.equals(Intent.ACTION_POWER_CONNECTED);

        if(!loading){
            throw new Error("Error! ACTION_POWER_CONNECTED Failed") ;
        }

        Toast.makeText(context, "A call has been started", Toast.LENGTH_LONG).show();
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel: "+ phone));
        context.startActivity(i);
    }


}
