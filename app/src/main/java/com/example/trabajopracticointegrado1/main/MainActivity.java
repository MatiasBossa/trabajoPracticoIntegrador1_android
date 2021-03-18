package com.example.trabajopracticointegrado1.main;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajopracticointegrado1.R;
import com.example.trabajopracticointegrado1.main.services.UsbConnection;

import static android.Manifest.permission.CALL_PHONE;

// TRABAJO PRACTICO 1 INTEGRADOR - MATIAS BOSSA


public class MainActivity extends AppCompatActivity {

    private IntentFilter usbIntentFilter;
    private UsbConnection usbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{CALL_PHONE}, 1000);
        }

        usbIntentFilter = new IntentFilter("android.hardware.usb.action.USB_STATE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        usbConnection = new UsbConnection();
        registerReceiver(usbConnection, usbIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(usbConnection);
    }
}