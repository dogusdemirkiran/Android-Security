package com.sec.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button showRunningProcessButton;
    private Button showPhoneFeaturesButton;
    private Button cleanCacheButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showRunningProcessButton = findViewById(R.id.showRunProcess);
        showPhoneFeaturesButton = findViewById(R.id.showPhoneFeatures);
        cleanCacheButton = findViewById(R.id.cleanCache);
/*
        showRunningProcessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRunningProcess();
            }
        });

        showPhoneFeaturesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhoneFeatures();
            }
        });*/
        //api();
    }


    public boolean networkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            return true;
        }else{
            return false;
        }
    }

    public void showRunningProcess(View view){
        Toast.makeText(getApplicationContext(),"Running Process",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    public void showPhoneFeatures(View view){
        Toast.makeText(getApplicationContext(),"Phone Features",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,PhoneFeaturesActivity.class);
        startActivity(intent);
    }

    public void cleanCache(View view){
        Toast.makeText(getApplicationContext(),"Clean Cache",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,CleanCacheActivity.class);
        startActivity(intent);
    }

    public void api(){
        if(networkConnection()){
            //WebView webView = new
        }else{
            Toast.makeText(getApplicationContext(),"No Connect",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
