package com.example.se300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {

    ViewPagerFragmentAdapter ViewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] titles= new String[]{"Rental Cars","Parking","Home","Ride Shares","Shuttle"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();       //This hides the title bar

        viewPager = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);

        viewPager.setAdapter(ViewPagerFragmentAdapter);

        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(titles[position]))).attach();


    }
}