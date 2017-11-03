package com.example.karl.wifi_scan;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.*;
import android.net.wifi.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WifiManager wifimanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifimanager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        Button button_open = (Button)findViewById(R.id.button_1);
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!wifimanager.isWifiEnabled()){
                    wifimanager.setWifiEnabled(true);
                }
                Intent intent = new Intent(MainActivity.this,OpenWiFi.class);
                startActivity(intent);
            }
        });
        Button button_close = (Button) findViewById(R.id.button_4);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifimanager.isWifiEnabled()){
                    wifimanager.setWifiEnabled(false);
                }
            }
        });
        Button button_exit = (Button)findViewById(R.id.button_5);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                finish();
                android.os.Process.killProcess(android.os.Process.myPid());

            }
        });
        Button button_scan = (Button)findViewById(R.id.button_2);
        button_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!wifimanager.isWifiEnabled()){
                    wifimanager.setWifiEnabled(true);
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, com.example.karl.wifi_scan.scanresult.class);
//                Bundle bundle = new Bundle();
//                bundle.
                startActivity(intent);
            }
        });



//        string[0]="Current ConnectionInfo: ";
//        string[1]="BSSID: "+wifiinfo.getBSSID();
//        string[2]="SSID: "+wifiinfo.getSSID();
//        string[3]="IP: "+intIP2StringIP(wifiinfo.getIpAddress());
//        string[4]="MAC: "+wifiinfo.getMacAddress();
//        string[5]="Rssi: "+wifiinfo.getRssi()+"dBm";
//        string[6]="LinkSpeed: "+wifiinfo.getLinkSpeed()+"Mbps";
//        string[7]="WifiInfo2String: "+wifiinfo.toString();
//        string[8]="HiddenSSID: "+wifiinfo.getHiddenSSID();
//        string[9]="NetworkID: "+wifiinfo.getNetworkId();
//        string[10]="Frequency: "+"2.4"+"GHz";
//
//
//        list_scanresult = wifimanager.getScanResults();
//        string1[0] = list_scanresult.get(0).SSID;
//        string1[1] = list_scanresult.get(0).BSSID;
//        string1[2] = list_scanresult.get(0).capabilities;

        //  string1[3] = list_scanresult.get(0).frequency+"MHz";
        //  string1[4] = list_scanresult.get(0).channelWidth+"MHz";

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("SSID",string1[0]);
//                intent.putExtra("BSSID",string1[1]);
//                intent.putExtra("capabilities",string1[2]);
//                intent.setClass(MainActivity.this, com.example.karl.wifi_scan.ScanResult.class);
//                startActivity(intent);
//            }
//        });
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,string);
//        ListView list = (ListView) findViewById(R.id.listview);
//        list.setAdapter(adapter);
    }
}
