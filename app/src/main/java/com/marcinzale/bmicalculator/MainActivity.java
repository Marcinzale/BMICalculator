package com.marcinzale.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NumberPicker numberPickerCm, numberPickerKg;
    TextView textView, textViewResultCm, textViewResultKg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        textViewResultCm = findViewById(R.id.textViewResultCm);
        textViewResultKg = findViewById(R.id.textViewResultKg);
        textView = findViewById(R.id.textView);

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

        textView.setText("Your BMI is: " + String.format("%.2f", bmi));
    }
}