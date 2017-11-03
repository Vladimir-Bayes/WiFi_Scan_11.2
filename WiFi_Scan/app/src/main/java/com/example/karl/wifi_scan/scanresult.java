package com.example.karl.wifi_scan;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KarL on 2017/11/2.
 */

public class scanresult extends Activity {
    private WifiManager wifimanager;
    private List<ScanResult> list_scanresult;
    List<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan);

        //Button Finish
        Button button_finish = (Button)findViewById(R.id.button_finish);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textview2);
                data.clear();
                textView.setText("NULL");
                finish();
            }
        });

        //Button Rescan
        Button button_rescan = (Button)findViewById(R.id.button_rescan);
        button_rescan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rescan();
            }
        });

        //Button Input
        Button button_input = (Button)findViewById(R.id.button_input);
        button_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edittext = (EditText)findViewById(R.id.edit_text_1);
                String input_MAC = edittext.getText().toString();
                TextView textview = (TextView)findViewById(R.id.textview_input_echo);
                textview.setText(input_MAC);
            }
        });

        //Button Check
        Button button_check = (Button)findViewById(R.id.button_3);
        button_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String target_MAC;
                TextView textView = (TextView)findViewById(R.id.textview2);
                TextView textView1 = (TextView)findViewById(R.id.textview_input_echo);
                target_MAC = textView1.getText().toString();
                for(int i=0;i<data.size();i++){
                    if(data.get(i).indexOf(target_MAC)!=-1){
                        if(i%2==1){
                            textView.setText("Check Result for "+target_MAC+": True\r\n"+"MAC: "+data.get(i)+"\r\nSSID: "+data.get(i-1));
                        }
                        else{
                            textView.setText("Check Result for "+target_MAC+": True\r\n"+"MAC: "+data.get(i+1)+"\r\nSSID: "+data.get(i));
                        }
                        break;
                    }

                }
            }
        });


    }
    public void rescan(){
        wifimanager =(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        list_scanresult = wifimanager.getScanResults();
        data.clear();
        if(list_scanresult.size()==0){
            finish();
        }else{
            for(int i=0;i<list_scanresult.size();i++){
                data.add(list_scanresult.get(i).SSID);
                data.add(list_scanresult.get(i).BSSID);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        ListView list = (ListView) findViewById(R.id.listview1);
        list.setAdapter(adapter);
    }
}
