package com.maselart.bmicalculator;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private RadioButton radioButtonFemale;
    private RadioButton radioButtonMale;
    private TextView ageText;
    private TextView heightText;
    private TextView weightText;
    private TextView calculationResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();

        setUpCalculateClickListener();
    }
    private void getViews()
    {
        calculateButton = findViewById(R.id.bmi_button_calculate);
        radioButtonFemale = findViewById(R.id.bmi_radio_button_female);
        radioButtonMale = findViewById(R.id.bmi_radio_button_male);
        ageText = findViewById(R.id.bmi_age);
        weightText = findViewById(R.id.bmi_weight);
        heightText = findViewById(R.id.bmi_height);
        calculationResult = findViewById(R.id.bmi_calculated_result);
    }

    private void setUpCalculateClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        try {
            int enteredAge = parseInt(ageText.getText().toString());
            float enteredWeight = Float.parseFloat(weightText.getText().toString());
            int enteredHeight = parseInt(heightText.getText().toString());

            float heightMeters =  Float.parseFloat(String.valueOf(enteredHeight)) / 100;
            float heightSqrt = heightMeters * heightMeters;
            float bmi = enteredWeight / heightSqrt;
            String bmiResult = String.format(Locale.getDefault(), "%.2f", bmi);
            calculationResult.setText(getString(R.string.bmi_result_format, bmiResult));
        } catch (NumberFormatException e) {
            calculationResult.setText(R.string.bmi_error_invalid_input);
        }

    }


}