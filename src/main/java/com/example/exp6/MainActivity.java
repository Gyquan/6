package com.example.exp6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;

import com.example.exp6.broadcast.BatteryLevelReceiver;
import com.example.exp6.broadcast.PowerConnectionReceiver;

public class MainActivity extends AppCompatActivity {
    private PowerConnectionReceiver powerConnectionReceiver;
    private BatteryLevelReceiver batteryLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerConnectionReceiver = new PowerConnectionReceiver();
        batteryLevelReceiver=new BatteryLevelReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(powerConnectionReceiver, filter);
        registerReceiver(batteryLevelReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerConnectionReceiver);
        unregisterReceiver(batteryLevelReceiver);
    }
}