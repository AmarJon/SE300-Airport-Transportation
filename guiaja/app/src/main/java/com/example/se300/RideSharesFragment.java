package com.example.se300;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class RideSharesFragment extends Fragment {

    ImageButton buttonLyft, buttonUber, buttonWingz;

    Drawable backgroundUber, backgroundLyft, backgroundWingz;
    View view;

    public RideSharesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_ride_shares, container, false);

        buttonUber = view.findViewById(R.id.uberImageButton);
        backgroundUber = buttonUber.getBackground();
        backgroundUber.setAlpha(0);
        buttonUber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.uber.com/");
                getActivity().startActivity(intent);
            }
        });

        buttonLyft = view.findViewById(R.id.lyftImageButton);
        backgroundLyft = buttonLyft.getBackground();
        backgroundLyft.setAlpha(0);
        buttonLyft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.lyft.com/");
                getActivity().startActivity(intent);
            }
        });

        buttonWingz = view.findViewById(R.id.wingzImageButton);
        backgroundWingz = buttonWingz.getBackground();
        backgroundWingz.setAlpha(0);
        buttonWingz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.wingz.me/");
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}