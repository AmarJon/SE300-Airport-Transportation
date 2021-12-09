package com.example.se300;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity{

    ViewPagerFragmentAdapter ViewPagerFragmentAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager;

    private String[] titles= new String[]{
            "Rental Cars",
            "Parking",
            "Home",
            "Ride Shares",
            "Shuttle"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //Hides the title bar

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            askPermissions();
        }
        else continueApp();



    }

    private void continueApp() {
        viewPager = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);

        viewPager.setAdapter(ViewPagerFragmentAdapter);
        viewPager.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout,viewPager,((tab, position) -> tab.setText(titles[position]))).attach();
        // Sets the HomeFragment() to the primary tab when the app gets open.
        viewPager.setCurrentItem(2, false);

    }

    private void askPermissions() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int result = this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

            if (result == PackageManager.PERMISSION_GRANTED){
                continueApp();
            }
            else {
                askLocationPermission();
            }
        }
    }

    private void askLocationPermission() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    continueApp();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    askPermissionAgain();
                }

            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void askPermissionAgain() {
        boolean showRationale = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            showRationale = shouldShowRequestPermissionRationale( Manifest.permission.ACCESS_FINE_LOCATION );
        }
        if (! showRationale) {
            AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
            AlertDialog alertDialog=builder.create();
            builder.setMessage("This is essential to use this app. Please provide this permission.");
            builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    openSomeActivityForResult();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                    finish();
                }
            });
            builder.show();
            // the app setting
        } else askLocationPermission();
    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                    }
                    askPermissions();
                }
            });

    public void openSomeActivityForResult() {
        Intent intent=new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri=Uri.fromParts("package",getPackageName(),null);
        intent.setData(uri);
        someActivityResultLauncher.launch(intent);
    }

}