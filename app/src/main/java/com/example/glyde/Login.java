package com.example.glyde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void switchActivities(View v){
        startActivity(new Intent(Login.this, signup.class));
    }

    public void chkInput(View view)
    {
        EditText email, pass;
        email = findViewById(R.id.ET_Email);
        pass = findViewById(R.id.ET_Password);

        if (email.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(),"Enter Email",Toast.LENGTH_LONG).show();

        if (pass.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
    }
}
