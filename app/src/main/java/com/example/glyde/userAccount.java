package com.example.glyde;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class userAccount extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    Button sign_out;
    TextView tv_name, tv_email, tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        setTitle("Account");

        sign_out = findViewById(R.id.BTN_UA_Signout);
        tv_name = findViewById(R.id.TV_UA_Name);
        tv_email = findViewById(R.id.TV_UA_Email);
        tv_id = findViewById(R.id.TV_UA_ID);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(userAccount.this);
        if (account != null)
        {
            String accName = account.getDisplayName();
            String accGivenName = account.getGivenName();
            String accFamName = account.getFamilyName();
            String accEmail = account.getEmail();
            String accID = account.getId();

            tv_name.setText(accName);
            tv_email.setText(accEmail);
            tv_id.setText(accID);
        }

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(userAccount.this, "Successfully Signed Out", Toast.LENGTH_LONG).show();
                        userAccount.this.startActivity(new Intent(userAccount.this, Login.class));
                        userAccount.this.finish();
                    }
                });
    }
}
