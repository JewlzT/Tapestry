package com.example.tapestry;

import java.util.ArrayList;
import java.util.List;

public class OptionsModel {
    private List<String> selectedOptions;

    public OptionsModel() {
        selectedOptions = new ArrayList<>();
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void addOption(String option) {
        if (!selectedOptions.contains(option)) {
            selectedOptions.add(option);
        }
    }

    public void removeOption(String option) {
        selectedOptions.remove(option);
    }

    public void clearOptions() {
        selectedOptions.clear();
    }

    public void setAllOptions(List<String> options) {
        selectedOptions = new ArrayList<>(options);
    }
}