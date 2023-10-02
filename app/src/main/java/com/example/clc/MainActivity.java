package com.example.clc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private boolean isNegativeMode = false;
    private TextView counterTextView;
    private Button incrementButton;
    private Button resetButton;
    private Switch switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.pointsTextView);
        incrementButton = findViewById(R.id.incrementButton);
        resetButton = findViewById(R.id.resetButton);
        switchButton = findViewById(R.id.switchButton);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNegativeMode) {
                    counter--;
                } else {
                    counter++;
                }
                updateCounterText();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 0;
                updateCounterText();
            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNegativeMode = isChecked;
            }
        });

        updateCounterText();
    }

    private void updateCounterText() {
        counterTextView.setText("Licznik: " + counter);
    }
}
