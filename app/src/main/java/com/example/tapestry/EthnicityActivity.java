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

public class EthnicityActivity extends AppCompatActivity {


    private OptionsModel ethnicity_model;

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
        setContentView(R.layout.activity_ethnicity);

        // Initialize model
        ethnicity_model = new OptionsModel();

        // Initialize views
        option1CheckBox = findViewById(R.id.eth_african_american);
        option2CheckBox = findViewById(R.id.eth_chinese);
        option3CheckBox = findViewById(R.id.eth_cuban);
        option4CheckBox = findViewById(R.id.eth_indian);
        option5CheckBox = findViewById(R.id.eth_puerto_rican);
        nextButton = findViewById(R.id.next_button_interests);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> selectedEthnicities = applyExperience();
                // Create an intent to start SecondActivity

                Intent intent = new Intent(EthnicityActivity.this, InterestsActivity.class);
                intent.putStringArrayListExtra("SELECTED_ETHNICITIES", new ArrayList<>(selectedEthnicities));
                startActivity(intent); // Start SecondActivity
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ethnicity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private List<String> applyExperience() {
        // Clear the previous selections
        ethnicity_model.clearOptions();
        // Add individual selections to the model
        if (option1CheckBox.isChecked()) {
            ethnicity_model.addOption("African American");
        }
        if (option2CheckBox.isChecked()) {
            ethnicity_model.addOption("Chinese");
        }
        if (option3CheckBox.isChecked()) {
            ethnicity_model.addOption("Cuban");
        }
        if (option4CheckBox.isChecked()) {
            ethnicity_model.addOption("Indian");
        }
        if (option5CheckBox.isChecked()) {
            ethnicity_model.addOption("Puerto Rican");
        }
        // Output the selected options (this could update another view or trigger other logic)
        return ethnicity_model.getSelectedOptions();
    }


}