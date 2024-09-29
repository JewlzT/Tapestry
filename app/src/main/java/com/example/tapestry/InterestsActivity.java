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
import android.widget.CheckBox;
import java.util.List;
import java.util.ArrayList;

public class InterestsActivity extends AppCompatActivity {


    private OptionsModel interest_model;

    // Initialize views
    private CheckBox option1CheckBox;
    private CheckBox option2CheckBox;
    private CheckBox option3CheckBox;
    private CheckBox option4CheckBox;
    private CheckBox option5CheckBox;
    private Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_interests);

        // Initialize model
        interest_model = new OptionsModel();

        // Initialize views
        option1CheckBox = findViewById(R.id.option1CheckBox);
        option2CheckBox = findViewById(R.id.option2CheckBox);
        option3CheckBox = findViewById(R.id.option3CheckBox);
        option4CheckBox = findViewById(R.id.option4CheckBox);
        option5CheckBox = findViewById(R.id.option5CheckBox);
        nextButton = findViewById(R.id.next_button_interests);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedInterests = applyExperience();
                // Create an intent to start SecondActivity

                Intent intent = new Intent(InterestsActivity.this, DoneActivity.class);
                intent.putStringArrayListExtra("SELECTED_ETHNICITIES", getIntent().getStringArrayListExtra("SELECTED_ETHNICITIES"));
                intent.putStringArrayListExtra("SELECTED_INTERESTS", new ArrayList<>(selectedInterests));
                startActivity(intent); // Start SecondActivity
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.interests), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private List<String> applyExperience() {
        // Clear the previous selections
        interest_model.clearOptions();
        // Add individual selections to the model
        if (option1CheckBox.isChecked()) {
            interest_model.addOption("Art");
        }
        if (option2CheckBox.isChecked()) {
            interest_model.addOption("History");
        }
        if (option3CheckBox.isChecked()) {
            interest_model.addOption("Food");
        }
        if (option4CheckBox.isChecked()) {
            interest_model.addOption("Language");
        }
        if (option5CheckBox.isChecked()) {
            interest_model.addOption("Community");
        }
        // Output the selected options (this could update another view or trigger other logic)
        List<String> selectedOptions = interest_model.getSelectedOptions();
        return interest_model.getSelectedOptions();
    }


}