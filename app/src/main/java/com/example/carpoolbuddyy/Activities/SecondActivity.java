package com.example.carpoolbuddyy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carpoolbuddyy.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void toUserProfActivity(View v) {
        Intent userProfileActivity = new Intent(getBaseContext(), UserProfileActivity.class);
        startActivity(userProfileActivity);
    }

    public void toVehicleInfoActivity(View v) {
        Intent vehicleInfoActivity = new Intent(getBaseContext(), VehicleInfoActivity.class);
        startActivity(vehicleInfoActivity);
    }
}