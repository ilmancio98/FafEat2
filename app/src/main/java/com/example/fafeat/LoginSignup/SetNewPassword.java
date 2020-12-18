package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.fafeat.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void call_success_massage(View view){

        Intent intent = new Intent(getApplicationContext(),ForgetPasswordSuccessMassage.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.ok_btn), "success_transition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( SetNewPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }
}