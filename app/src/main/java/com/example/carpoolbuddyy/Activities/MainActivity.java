package com.example.carpoolbuddyy.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.carpoolbuddyy.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toLogInActivity(View v) {
        Intent logInActivity = new Intent(getBaseContext(), LogInActivity.class);
        startActivity(logInActivity);
    }

    public void toSignInActivity(View v) {
        Intent registerActivity = new Intent(getBaseContext(), RegisterActivity.class);
        startActivity(registerActivity);
    }
}