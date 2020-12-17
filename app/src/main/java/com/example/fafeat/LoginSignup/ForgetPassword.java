package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.fafeat.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
    }

    public void call_make_selection(View view){

        Intent intent = new Intent(getApplicationContext(),Make_selection.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next_btn), "forget_transition");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( ForgetPassword.this, pairs);
        startActivity(intent, options.toBundle());
    }
}