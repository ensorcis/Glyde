package com.example.glyde;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }

    public void vaildateInput(View view) {
        EditText name, email, password;
        name = findViewById(R.id.ET_Signup_Name);
        email = findViewById(R.id.ET_SignUp_Email);
        password = findViewById(R.id.ET_Signup_Pass);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        setContentView(view);

        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
        } else {
            if (email.getText().toString().trim().matches(emailPattern)) {
                Toast.makeText(getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            }
        }

        if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fields Empty", Toast.LENGTH_LONG).show();
        }
    }
}
