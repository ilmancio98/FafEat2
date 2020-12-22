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
    Button login;
    TextView titleText;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupcust2);

        backbtn = findViewById(R.id.signup_cust__back_button);
        login = findViewById(R.id.signup_login_btn);
        titleText = findViewById(R.id.signup_title_text);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);





    }

    public void callLogin(View view) {

        if (!validateGender() | !validateAge()){
            return;
        }


        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();


        String _date = day+"/"+month+"/"+year;

        String _name = getIntent().getStringExtra("name");
        String _email = getIntent().getStringExtra("email_");
        String _password = getIntent().getStringExtra("password_");

        Intent intent = new Intent(getApplicationContext(), Login.class);

        intent.putExtra("name", _name);
        intent.putExtra("email_", _email);
        intent.putExtra("password_", _password);
        intent.putExtra("gender_", _gender);
        intent.putExtra("date_", _date);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(login, "transition_login");

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