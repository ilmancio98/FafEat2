package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.fafeat.R;

public class Make_selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void call_OTP_verification(View view){

        Intent intent = new Intent(getApplicationContext(),VerificationOtp.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.mobile_btn), "forget_transition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( Make_selection.this, pairs);
        startActivity(intent, options.toBundle());
    }
}