package com.example.carpoolbuddyy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carpoolbuddyy.Models.Vehicles.Vehicle;
import com.example.carpoolbuddyy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class VehicleInfoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private Vehicle vehicleInfo;
    private ArrayList<Vehicle> vehiclesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_info);
    }

    public void getAndPopulateData(){

    }

    public void goToAddVehicle(View v) {
        Intent addVehicleActivity = new Intent(getBaseContext(), AddVehicleActivity.class);
        startActivity(addVehicleActivity);
    }
}