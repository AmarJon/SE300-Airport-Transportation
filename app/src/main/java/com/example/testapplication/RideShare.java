package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RideShare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_share);
    }
    public void browser1(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.uber.com/"));
        startActivity(browserIntent);
    }
}