package com.example.glyde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class signup extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("Sign Up");

    }

    public void vaildateInput(View view) {
        EditText name, email, password;
        name = findViewById(R.id.ET_Signup_Name);
        email = findViewById(R.id.ET_SignUp_Email);
        password = findViewById(R.id.ET_Signup_Pass);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
            email.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        } else if (!email.getText().toString().trim().matches(emailPattern)) {
            Toast.makeText(getApplicationContext(), "Email Form Invalid", Toast.LENGTH_SHORT).show();
            email.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }

        if (name.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Name Empty", Toast.LENGTH_LONG).show();
            name.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }else if (password.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Password Empty", Toast.LENGTH_LONG).show();
            password.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
        }
    }
}