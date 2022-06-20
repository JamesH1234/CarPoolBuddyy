package com.example.carpoolbuddyy.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.carpoolbuddyy.Models.Vehicles.Car;
import com.example.carpoolbuddyy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LogInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        emailField = findViewById(R.id.EmailField);
        passwordField = findViewById(R.id.PasswordField);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    public void reload() {
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    void uploadData(FirebaseUser mUser){

    }

    public void signIn(View v){
        String emailString = emailField.getText().toString();
        String passwordString = passwordField.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("SIGNIN SUCESSFULL", "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    Log.w("SIGNIN SUCESSFULL", "signInWithEmail:failure", task.getException());
                    updateUI(null);
                }
            }
        });
    }

    void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }

}