package com.example.carpoolbuddyy.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.carpoolbuddyy.Models.Users.Alumni;
import com.example.carpoolbuddyy.Models.Users.Parent;
import com.example.carpoolbuddyy.Models.Users.Student;
import com.example.carpoolbuddyy.Models.Users.Teacher;
import com.example.carpoolbuddyy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;

    private EditText emailField;
    private EditText passwordField;
    private EditText nameField;

    private LinearLayout layout;
    private Spinner spinner;
    private String selection;

    private EditText gradYearField;
    private EditText parentUIDField;
    private EditText inSchoolTitleField;
    private EditText childrenTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        layout = findViewById(R.id.layout);
        spinner = findViewById(R.id.spinner);

        createSpinner();

        emailField = findViewById(R.id.EmailField);
        passwordField = findViewById(R.id.PasswordField);

//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            updateUI(currentUser);
//        }
    }

    private void createSpinner() {
        String[] userTypes = {"Student", "Teacher", "Alumni", "Parent"};
        ArrayAdapter<String> langArrAdapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item, userTypes);
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
        emailField = new EditText(this);
        emailField.setHint("Email");
        layout.addView(emailField);
        passwordField = new EditText(this);
        passwordField.setHint("Password");
        layout.addView(passwordField);
        nameField = new EditText(this);
        nameField.setHint("Name");
        layout.addView(nameField);
    }

    public void addFields() {
        defaultFields();

        switch(selection) {
            case "Student":
                gradYearField = new EditText(this);
                parentUIDField = new EditText(this);
                gradYearField.setHint("Graduation year");
                parentUIDField.setHint("Parent UID");
                layout.addView(gradYearField);
                layout.addView(parentUIDField);
                break;

            case "Teacher":
                inSchoolTitleField = new EditText(this);
                inSchoolTitleField.setHint("Title");
                layout.addView(inSchoolTitleField);
                break;

            case "Alumni":
                gradYearField = new EditText(this);
                gradYearField.setHint("Graduation year");
                layout.addView(gradYearField);
                break;

            case "Parent":
                childrenTextField = new EditText(this);
                childrenTextField.setHint("Children (separate with only a comma)");
                layout.addView(childrenTextField);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    void uploadData(FirebaseUser mUser){

    }

    public void signUp(View v){
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        String name = nameField.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Log.d("SIGN UP", "successfully signed up the user");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else {
                    Log.d("SIGN UP", "createUserWithEmail:failure", task.getException());
                    updateUI(null);
                }
            }
        });

        DocumentReference newUser = firestore.collection("users").document();
        String uid = newUser.getId();

        switch(selection) {
            case "Student":
                int gradYearStudent = Integer.parseInt(gradYearField.getText().toString());
                Student addStudent = new Student(uid, name, email, selection, 1.0, new ArrayList<String>(), gradYearStudent, new ArrayList<String>());
                newUser.set(addStudent);
                break;
            case "Teacher":
                String inSchoolName = inSchoolTitleField.getText().toString();
                Teacher addTeacher = new Teacher(uid, name, email, selection, 1.0, new ArrayList<String>(), inSchoolName);
                newUser.set(addTeacher);
                break;
            case "Alumni":
                int gradYearAlumni = Integer.parseInt(gradYearField.getText().toString());
                Alumni addAlumni = new Alumni(uid, name, email, selection, 1.0, new ArrayList<String>(), gradYearAlumni);
                newUser.set(addAlumni);
                break;
            case "Parent":
                ArrayList<String> children = new ArrayList<>();
                String[] childrenArr = childrenTextField.getText().toString().split(",");
                for(int i = 0; i < childrenArr.length; i++) {
                    children.add(childrenArr[i]);
                }
                Parent addParent = new Parent(uid, name, email, selection, 1.0, new ArrayList<>(), children);
                newUser.set(addParent);
                break;
        }
        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }

    public void updateUI(FirebaseUser user) {
        if(user != null) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }

}