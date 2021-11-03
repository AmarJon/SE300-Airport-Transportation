package com.example.se300;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RideSharesFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        openUrl("https://m.uber.com/");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ride_shares, container, false);
    }
    
    public void openUrl(String url){
        Uri uri=Uri.parse(url);
        Intent launchWeb=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(launchWeb);
    }
}