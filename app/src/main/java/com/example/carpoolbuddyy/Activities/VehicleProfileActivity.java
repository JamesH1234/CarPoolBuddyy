package com.example.carpoolbuddyy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.carpoolbuddyy.Models.Vehicles.Vehicle;
import com.example.carpoolbuddyy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class VehicleProfileActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Vehicle vehicleInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_profile);
    }

    void setUpButton(){
    }

    void bookRide() {
    }

}