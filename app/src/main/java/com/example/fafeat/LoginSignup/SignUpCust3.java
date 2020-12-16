package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.fafeat.R;

public class SignUpCust3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_cust3);
    }

    public void callNextVerificationScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), VerificationOtp.class);

        Pair[] pairs = new Pair[0];
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpCust3.this, pairs);
        startActivity(intent, options.toBundle());
    }
}