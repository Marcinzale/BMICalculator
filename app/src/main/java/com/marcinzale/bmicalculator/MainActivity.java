package com.marcinzale.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Integer height, weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        TextView textViewResultCm = findViewById(R.id.textViewResultCm);
        TextView textViewResultKg = findViewById(R.id.textViewResultKg);

        NumberPicker numberPickerCm = findViewById(R.id.numberPickerCm);
        NumberPicker numberPickerKg = findViewById(R.id.numberPickerKg);

        numberPickerCm.setMinValue(100);
        numberPickerCm.setMaxValue(220);
        numberPickerCm.setValue(160);

        numberPickerKg.setMinValue(40);
        numberPickerKg.setMaxValue(200);
        numberPickerKg.setValue(60);

        numberPickerCm.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPickerCm, int oldValue, int newValue) {
                textViewResultCm.setText("Cm = " + newValue);
            }
        });
        numberPickerKg.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPickerKg, int oldValue, int newValue) {
//                weight = newValue;
                textViewResultKg.setText("Kg = " + newValue);
            }
        });

    }
}