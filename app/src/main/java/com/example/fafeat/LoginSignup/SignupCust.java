package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fafeat.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SignupCust extends AppCompatActivity {

    //Variables
    ImageView backbtn;
    Button next;
    TextView titleText;

    //Get data variables
    TextInputLayout fullName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_cust);

        //Hooks for animation
        backbtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        titleText = findViewById(R.id.signup_title_text);

        //Hooks for getting data
        fullName = findViewById(R.id.signup_fullname);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);


    }


    public void callNextSignupScreen(View view) {

        if (!validateFullName() | !validateEmail() | !validatePassword()){
            return;
        }

        String _name = Objects.requireNonNull(fullName.getEditText()).getText().toString();
        String _email = Objects.requireNonNull(email.getEditText()).getText().toString();
        String _password = Objects.requireNonNull(password.getEditText()).getText().toString();

        Intent intent = new Intent(getApplicationContext(), Signupcust2.class);

        intent.putExtra("name", _name);
        intent.putExtra("email_", _email);
        intent.putExtra("password_", _password);




        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(titleText, "transition_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignupCust.this, pairs);
        startActivity(intent, options.toBundle());
    }

    /*
    Validation Function*/


    private boolean validateFullName() {
        String val = Objects.requireNonNull(fullName.getEditText()).getText().toString().trim();

        if (val.isEmpty()) {
            fullName.setError("Il campo non può essere vuoto");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = Objects.requireNonNull(email.getEditText()).getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Il campo non può esssere vuoto");
            return false;
        }else if (!val.matches(checkEmail)) {
            email.setError("Email non valida!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = Objects.requireNonNull(password.getEditText()).getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Il campo non può essere vuoto");
            return false;

        }else if (!val.matches(checkPassword)) {
            password.setError("Password should contain 4 characters!");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
}