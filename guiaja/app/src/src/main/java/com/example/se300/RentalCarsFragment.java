package com.example.se300;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class RentalCarsFragment extends Fragment {



    public RentalCarsFragment() {
        // Required empty public constructor
    }

    ImageButton avis, enterprise, budget;
    Drawable backgroundAvis, backgroundBudget;


    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_rental_cars, container, false);

        avis = view.findViewById(R.id.avisImageButton);
        enterprise = view.findViewById(R.id.enterpriseImageButton);
        budget = view.findViewById(R.id.budgetImageButton);

        backgroundAvis = avis.getBackground();
        backgroundAvis.setAlpha(0);
        avis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.avis.com/en/offers/us-offers/fall-sale?AWD_NUMBER=D486601&gclid=Cj0KCQiAys2MBhDOARIsAFf1D1cyX4AS8MwbrPQM4I5gOb4AN7cfMR_MbpHSUG7w13cHxUHtHjhdpHAaAtACEALw_wcB&gclsrc=aw.ds");
                getActivity().startActivity(intent);
            }
        });

        enterprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.enterprise.com/en/home.html");
                getActivity().startActivity(intent);
            }
        });

        backgroundBudget = budget.getBackground();
        backgroundBudget.setAlpha(0);
        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),WebViewActivity.class);
                intent.putExtra("url","https://www.budget.com/en/home");
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}