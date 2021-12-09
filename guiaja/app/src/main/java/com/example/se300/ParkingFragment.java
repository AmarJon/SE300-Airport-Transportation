package com.example.se300;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ParkingFragment extends Fragment {

    ImageButton informationLogo;
    ImageButton informationLogo2;
    ImageButton informationLogo3;
    ImageButton informationLogo4;
    ImageButton informationLogo5;
    ImageButton informationLogo6;
    ImageButton informationLogo7;
    ImageButton informationLogo8;

   Button purchaseBtn;

    Drawable backgroundInformationLogo;
    Drawable backgroundInformationLogo2;
    Drawable backgroundInformationLogo3;
    Drawable backgroundInformationLogo4;
    Drawable backgroundInformationLogo5;
    Drawable backgroundInformationLogo6;
    Drawable backgroundInformationLogo7;
    Drawable backgroundInformationLogo8;


    View view;

    public ParkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_parking, container, false);

        informationLogo = view.findViewById(R.id.informationButton);
        informationLogo2 = view.findViewById(R.id.informationButton2);
        informationLogo3 = view.findViewById(R.id.informationButton3);
        informationLogo4 = view.findViewById(R.id.informationButton4);
        informationLogo5 = view.findViewById(R.id.informationButton5);
        informationLogo6 = view.findViewById(R.id.informationButton6);
        informationLogo7 = view.findViewById(R.id.informationButton7);
        informationLogo8 = view.findViewById(R.id.informationButton8);

        purchaseBtn= view.findViewById(R.id.purchaseBtn);

        backgroundInformationLogo = informationLogo.getBackground();
        backgroundInformationLogo.setAlpha(0);
        backgroundInformationLogo2 = informationLogo2.getBackground();
        backgroundInformationLogo2.setAlpha(0);
        backgroundInformationLogo3 = informationLogo3.getBackground();
        backgroundInformationLogo3.setAlpha(0);
        backgroundInformationLogo4 = informationLogo4.getBackground();
        backgroundInformationLogo4.setAlpha(0);
        backgroundInformationLogo5 = informationLogo5.getBackground();
        backgroundInformationLogo5.setAlpha(0);
        backgroundInformationLogo6 = informationLogo6.getBackground();
        backgroundInformationLogo6.setAlpha(0);
        backgroundInformationLogo7 = informationLogo7.getBackground();
        backgroundInformationLogo7.setAlpha(0);
        backgroundInformationLogo8 = informationLogo8.getBackground();
        backgroundInformationLogo8.setAlpha(0);

        informationLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.North_Economy), "$10");
            }
        });

        informationLogo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.North_Cell_Lot), "Free");
            }
        });

        informationLogo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.South_Economy
                ), "$10");
            }
        });

        informationLogo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.South_Cell_Lot), "Free");
            }
        });

        informationLogo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.Terminal_B), "$19");
            }
        });

        informationLogo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.Terminal_Top), "$19");
            }
        });

        informationLogo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.Terminal_A), "$19");
            }
        });

        informationLogo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog(getResources().getString(R.string.Terminal_C), "17");
            }
        });


        return view;

    }

    private void showInfoDialog(String info, String price) {
        Dialog dialog= new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.info_layout);

        TextView infoTv= dialog.findViewById(R.id.parkingInfoTv);
        Button purchaseBtn= dialog.findViewById(R.id.purchaseBtn);
        infoTv.setText(info);

        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCardCredentialsDeialog(price);
            }
        });



        dialog.show();
    }

    private void showCardCredentialsDeialog(String price) {
        Dialog dialog= new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.credentials_layout);

        Button proceedBtn= dialog.findViewById(R.id.proceedBtn);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), PaymentActivity.class);
                intent.putExtra("price", price);
                getActivity().startActivity(intent);
                dialog.dismiss();
            }
        });




        dialog.show();
    }
}