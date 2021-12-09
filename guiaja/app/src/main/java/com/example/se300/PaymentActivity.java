package com.example.se300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    Button doneBtn;
    String price;
    TextView priceTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        doneBtn= findViewById(R.id.doneBtn);
        price= getIntent().getStringExtra("price");
        priceTv= findViewById(R.id.priceTv);

        priceTv.setText("1 Ticket for "+price);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Toast.makeText(PaymentActivity.this, "Parking has been puchased...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}