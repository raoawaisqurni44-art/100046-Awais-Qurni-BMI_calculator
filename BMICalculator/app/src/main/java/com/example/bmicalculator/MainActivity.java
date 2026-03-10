package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private Button btnCalculate, btnReset;
    private TextView tvResult, tvCategory, tvInfo, tvWeightLabel, tvHeightLabel;
    private RadioGroup rgUnits;
    private RadioButton rbMetric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnReset = findViewById(R.id.btnReset);
        tvResult = findViewById(R.id.tvResult);
        tvCategory = findViewById(R.id.tvCategory);
        tvInfo = findViewById(R.id.tvInfo);
        tvWeightLabel = findViewById(R.id.tvWeightLabel);
        tvHeightLabel = findViewById(R.id.tvHeightLabel);
        rgUnits = findViewById(R.id.rgUnits);
        rbMetric = findViewById(R.id.rbMetric);

        // Unit change listener
        rgUnits.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbMetric) {
                    tvWeightLabel.setText("Weight (kg)");
                    tvHeightLabel.setText("Height (cm)");
                    etWeight.setHint("Enter weight in kg");
                    etHeight.setHint("Enter height in cm");
                } else {
                    tvWeightLabel.setText("Weight (lb)");
                    tvHeightLabel.setText("Height (ft)");
                    etWeight.setHint("Enter weight in lb");
                    etHeight.setHint("Enter height in ft (e.g. 5.7)");
                }
                resetFields();
            }
        });

        // Calculate button click listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        // Reset button click listener
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = etWeight.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double weight = Double.parseDouble(weightStr);
            double heightInput = Double.parseDouble(heightStr);

            if (weight <= 0 || heightInput <= 0) {
                Toast.makeText(this, "Please enter valid positive numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            double bmi;
            if (rbMetric.isChecked()) {
                // Metric: weight (kg), height (cm)
                double heightM = heightInput / 100;
                bmi = weight / (heightM * heightM);
            } else {
                // Imperial: weight (lb), height (ft)
                // 1 ft = 12 inches. BMI = (weight_lb * 703) / (height_in)^2
                double heightInches = heightInput * 12;
                bmi = (weight * 703) / (heightInches * heightInches);
            }

            String bmiFormatted = String.format(Locale.US, "%.2f", bmi);
            tvResult.setText("Your BMI: " + bmiFormatted);
            tvResult.setVisibility(View.VISIBLE);

            displayCategory(bmi);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayCategory(double bmi) {
        String category;
        int colorRes;
        String info;

        if (bmi < 18.5) {
            category = "Underweight";
            colorRes = android.R.color.holo_blue_dark;
            info = "You may need to gain weight. Consult a healthcare provider.";
        } else if (bmi >= 18.5 && bmi < 25) {
            category = "Normal Weight";
            colorRes = android.R.color.holo_green_dark;
            info = "You have a healthy weight. Keep it up!";
        } else if (bmi >= 25 && bmi < 30) {
            category = "Overweight";
            colorRes = android.R.color.holo_orange_dark;
            info = "You may need to lose some weight. Consider a healthy diet and exercise.";
        } else {
            category = "Obese";
            colorRes = android.R.color.holo_red_dark;
            info = "You should consult a healthcare provider for guidance.";
        }

        tvCategory.setText("Category: " + category);
        tvCategory.setTextColor(ContextCompat.getColor(this, colorRes));
        tvCategory.setVisibility(View.VISIBLE);

        tvInfo.setText(info);
        tvInfo.setVisibility(View.VISIBLE);
    }

    private void resetFields() {
        etWeight.setText("");
        etHeight.setText("");
        tvResult.setVisibility(View.GONE);
        tvCategory.setVisibility(View.GONE);
        tvInfo.setVisibility(View.GONE);
        etWeight.requestFocus();
    }
}
