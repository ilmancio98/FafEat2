package com.example.fafeat.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fafeat.R;

import java.util.Calendar;

public class Signupcust2 extends AppCompatActivity {

    ImageView backbtn;
    Button next;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupcust2);

        backbtn = findViewById(R.id.signup_cust__back_button);
        next = findViewById(R.id.signup_next_button);
        titleText = findViewById(R.id.signup_title_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);
    }

    public void callNextSignup3Screen(View view) {

        if (!validateGender() | !validateAge()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();


        String date = day+"/"+month+"/"+year;

        Intent intent = new Intent(getApplicationContext(), SignUpCust3.class);

        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<View, String>(backbtn, "transition_back_arrow");
        pairs[1] = new Pair<View, String>(next, "transition_next");
        pairs[2] = new Pair<View, String>(titleText, "transition_title");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signupcust2.this, pairs);
        startActivity(intent, options.toBundle());
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Seleziona il sesso", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "Devi essere maggiore di 14 anni per iscriverti", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}