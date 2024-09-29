package com.example.tapestry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_done);
        ArrayList<String> selectedEthnicities = getIntent().getStringArrayListExtra("SELECTED_ETHNICITIES");
        ArrayList<String> selectedInterests = getIntent().getStringArrayListExtra("SELECTED_INTERESTS");
        // Display the selected options
        TextView optionsTextView = findViewById(R.id.optionsTextView);
        TextView optionsTextView2 = findViewById(R.id.optionsTextView2);
        // Make sure to have a TextView with this ID in your layout
        if (selectedEthnicities != null && !selectedEthnicities.isEmpty()) {
            StringBuilder ethnicityString = new StringBuilder("Selected Options:\n");
            for (String option : selectedEthnicities) {
                ethnicityString.append(option).append("\n");
            }
            optionsTextView.setText(ethnicityString.toString());
        } else {
            optionsTextView.setText("No options selected.");
        }
        if (selectedInterests != null && !selectedInterests.isEmpty()) {
            StringBuilder interestsString = new StringBuilder("Selected Options:\n");
            for (String option : selectedInterests) {
                interestsString.append(option).append("\n");
            }
            optionsTextView2.setText(interestsString.toString());
        } else {
            optionsTextView2.setText("No options selected.");
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.done), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}