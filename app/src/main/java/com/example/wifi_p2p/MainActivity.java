package com.example.wifi_p2p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnonoff,discover,send;
    ListView listview;
    TextView readtext,connectionstatus;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialwork();
    }

    private void intialwork()
    {
        btnonoff=(Button)findViewById(R.id.onOff);
        discover=(Button)findViewById(R.id.discover);
        send=(Button)findViewById(R.id.sendButton);
        readtext=(TextView) findViewById(R.id.readMsg);
        connectionstatus=(TextView) findViewById(R.id.connectionStatus);
        editText=(EditText)findViewById(R.id.writeMsg);
        listview=(ListView)findViewById(R.id.peerListView);
        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String s1=btnonoff.getText().toString();
                String s2=discover.getText().toString();
                String s3=new String();
                WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if(wifi.isWifiEnabled())
                {
                     s3="Yes";
                }
                else
                     s3="No";



                Toast.makeText(MainActivity.this, s3, Toast.LENGTH_LONG).show();
            }
        });
        btnonoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if(wifi.isWifiEnabled())
                {
                    wifi.setWifiEnabled(false);
                    btnonoff.setText("WIFI ON");
                }
                else {
                    wifi.setWifiEnabled(true);
                    btnonoff.setText("WIFI OFF");
                }
            }
        });

    }


}