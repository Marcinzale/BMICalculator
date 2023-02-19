package com.marcinzale.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NumberPicker numberPickerCm, numberPickerKg;
    TextView textViewResultCm, textViewResultKg, textViewResult, textViewMessage, textViewBmiValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        textViewResult = findViewById(R.id.textViewResult);
        textViewMessage = findViewById(R.id.textViewMessage);
        textViewBmiValue = findViewById(R.id.textViewBmiValue);

        numberPickerCm = findViewById(R.id.numberPickerCm);
        numberPickerKg = findViewById(R.id.numberPickerKg);

        numberPickerCm.setMinValue(100);
        numberPickerCm.setMaxValue(220);
        numberPickerCm.setValue(160);

        numberPickerKg.setMinValue(40);
        numberPickerKg.setMaxValue(200);
        numberPickerKg.setValue(60);

        numberPickerCm.setOnValueChangedListener((numberPickerCm, oldValue, newValue) -> calculateBmi());
        numberPickerKg.setOnValueChangedListener((numberPickerKg, oldValue, newValue) -> calculateBmi());

    }
    private void calculateBmi() {
        String height = String.valueOf(numberPickerCm.getValue());
        String weight = String.valueOf(numberPickerKg.getValue());

        float heightValue = Float.parseFloat(height);
        float weightValue = Float.parseFloat(weight);

        float bmi = (float) (weightValue / (heightValue * heightValue)*100)*100;

        textViewBmiValue.setText(String.format("%.2f", bmi));

        if (bmi < 16.0) {
            textViewMessage.setText ("This is starvation. You need to eat more");
        } else if ((bmi > 16) && (bmi <= 16.9)) {
            textViewMessage.setText ("This is emaciation. You need to eat more");
        } else if ((bmi >= 17.0) && (bmi <= 18.5)) {
            textViewMessage.setText ("This is underweight. You need to eat more");
        } else if ((bmi > 18.5) && (bmi <= 24.9)) {
            textViewMessage.setText ("Your weight is correct");
        } else if ((bmi >= 25) && (bmi < 29.9)) {
            textViewMessage.setText ("Overweight");
        } else if ((bmi >= 30) && (bmi <= 34.9)) {
            textViewMessage.setText ("First degree obesity");
        } else if ((bmi >= 35) && (bmi <= 39.9)) {
            textViewMessage.setText ("Second degree obesity");
        } else if (bmi >= 40) {
            textViewMessage.setText ("Third degree obesity");
        }
    }
}