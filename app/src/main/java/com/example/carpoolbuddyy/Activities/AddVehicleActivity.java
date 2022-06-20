package com.example.carpoolbuddyy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.carpoolbuddyy.Models.Vehicles.Bicycle;
import com.example.carpoolbuddyy.Models.Vehicles.Car;
import com.example.carpoolbuddyy.Models.Vehicles.Helicopter;
import com.example.carpoolbuddyy.Models.Vehicles.Segway;
import com.example.carpoolbuddyy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AddVehicleActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private LinearLayout layout;
    private Spinner spinner;
    private String selection;

    private EditText ownerField;
    private EditText modelField;
    private EditText capacityField;
    private EditText basePriceField;
    private EditText weightField;
    private EditText weightCapacityField;
    private EditText rangeField;
    private EditText maxAltitudeField;
    private EditText maxAirSpeedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.layout2);
        spinner = findViewById(R.id.spinner2);

        createSpinner();

    }

    private void createSpinner() {
        String[] vehicleTypes = {"Car", "Bicycle", "Helicopter", "Segway"};
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(AddVehicleActivity.this,
                android.R.layout.simple_spinner_item, vehicleTypes);
        langArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(langArrAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selection = parent.getItemAtPosition(position).toString();
                addFields();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void defaultFields() {
        layout.removeAllViewsInLayout();
        ownerField = new EditText(this);
        ownerField.setHint("Email");
        layout.addView(ownerField);
        modelField = new EditText(this);
        modelField.setHint("Password");
        layout.addView(modelField);
        capacityField = new EditText(this);
        capacityField.setHint("Name");
        layout.addView(capacityField);
        basePriceField = new EditText(this);
        basePriceField.setHint("Name");
        layout.addView(basePriceField);
    }

    private void addFields() {
        defaultFields();

        switch(selection) {
            case "Car":
                rangeField = new EditText(this);
                rangeField.setHint("Range");
                layout.addView(rangeField);
                break;

            case "Bicycle":
                weightField = new EditText(this);
                weightCapacityField = new EditText(this);
                weightField.setHint("Weight");
                weightField.setHint("Weight Capacity");
                layout.addView(weightField);
                layout.addView(weightCapacityField);
                break;

            case "Helicopter":
                maxAltitudeField = new EditText(this);
                maxAirSpeedField = new EditText(this);
                maxAltitudeField.setHint("Max Altitude");
                maxAirSpeedField.setHint("Max Air Speed");
                layout.addView(maxAltitudeField);
                layout.addView(maxAirSpeedField);
                break;

            case "Segway":
                rangeField = new EditText(this);
                weightCapacityField = new EditText(this);
                rangeField.setHint("Range");
                weightCapacityField.setHint("Weight Capacity");
                layout.addView(rangeField);
                layout.addView(weightCapacityField);
                break;
        }
    }

    boolean formValid() {
        return true;
    }

    public void addNewVehicle(View v) {
        String owner = ownerField.getText().toString();
        String model = modelField.getText().toString();
        int capacity = Integer.parseInt(capacityField.getText().toString());
        int basePrice = Integer.parseInt(basePriceField.getText().toString());

        DocumentReference newVehicle = firestore.collection("vehicles").document();
        String uid = newVehicle.getId();

        ArrayList<String> riders = new ArrayList<>();

        switch(selection) {
            case "Car":
                int rangeCar = Integer.parseInt(rangeField.getText().toString());
                Car addCar = new Car(owner, model, capacity, basePrice, uid, riders, true, selection, rangeCar);
                newVehicle.set(addCar);
                break;
            case "Bicycle":
                int weight = Integer.parseInt(weightField.getText().toString());
                int weightCapacityBicycle = Integer.parseInt(weightCapacityField.getText().toString());
                Bicycle addBicycle = new Bicycle(owner, model, capacity, basePrice, uid, riders, true, selection, weight, weightCapacityBicycle);
                newVehicle.set(addBicycle);
                break;
            case "Helicopter":
                int maxAltitude = Integer.parseInt(maxAltitudeField.getText().toString());
                int maxAirSpeed = Integer.parseInt(maxAirSpeedField.getText().toString());
                Helicopter addHelicopter = new Helicopter(owner, model, capacity, basePrice, uid, riders, true, selection, maxAltitude, maxAirSpeed);
                newVehicle.set(addHelicopter);
                break;
            case "Segway":
                int rangeSegway = Integer.parseInt(weightField.getText().toString());
                int weightCapacitySegway = Integer.parseInt(weightCapacityField.getText().toString());
                Segway addSegway = new Segway(owner, model, capacity, basePrice, uid, riders, true, selection, rangeSegway, weightCapacitySegway);
                newVehicle.set(addSegway);
                break;
        }
    }
}