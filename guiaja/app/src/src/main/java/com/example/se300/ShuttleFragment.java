package com.example.se300;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ShuttleFragment extends Fragment {

    ImageButton mearsButton;
    View view;


    public ShuttleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shuttle, container, false);

        mearsButton = view.findViewById(R.id.mearsImageButton);
        mearsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.mearstransportation.com/");
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}