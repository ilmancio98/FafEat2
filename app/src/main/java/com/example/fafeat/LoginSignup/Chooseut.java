package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.fafeat.R;

public class Chooseut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chooseut);
    }
    public void callsignupcust(View view){

        Intent intent = new Intent(getApplicationContext(),SignupCust.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.client_btn), "transition_choose");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( Chooseut.this, pairs);
        startActivity(intent, options.toBundle());
    }

}