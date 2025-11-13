package com.lpzpassgen.lpzpassgen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Controller {

    @FXML
    private Label slider_info;

    @FXML
    private Label slider_description;

    @FXML
    private Slider char_num;

    @FXML
    private TextArea main_field;

    @FXML
    private CheckBox numbers_check, letters_check, characters_check;

    @FXML
    private Button generate_button, copy_button;

    @FXML
    private void updateSliderInfo(MouseEvent event) {
        slider_info.setText(String.format("%.0f", char_num.getValue()));
    }

    @FXML
    public void initialize() {
        if (char_num != null) {
            char_num.setMin(4);    // enforce minimum password length
            char_num.setValue(12); // default starting value
        }

        if (slider_info != null && char_num != null) {
            slider_info.setText(String.format("%.0f", char_num.getValue()));
            char_num.valueProperty().addListener((obs, oldV, newV) ->
                    slider_info.setText(String.format("%.0f", newV.doubleValue())));
        }
    }

    @FXML
    private void generate(ActionEvent event) {
        boolean numbers = numbers_check != null && numbers_check.isSelected();
        boolean letters = letters_check != null && letters_check.isSelected();
        boolean characters = characters_check != null && characters_check.isSelected();

        int len = (char_num != null) ? (int)Math.round(char_num.getValue()) : 12;
        if (len <= 0) {
            len = 12; // fallback default
        }

        if (!numbers && !letters && !characters) {
            letters = true; // default to letters if nothing selected
        }

        try {
            Generator gen = new Generator(numbers, letters, characters, len);
            main_field.setText(gen.generatePassword());
        } catch (IllegalArgumentException e) {
            main_field.setText("⚠ " + e.getMessage());
        }
    }

    @FXML
    private void copyToClipboard(ActionEvent event) {
        if (main_field != null) {
            String text = main_field.getText();
            if (text != null && !text.isEmpty()) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(text);
                clipboard.setContent(content);
            }

        }

    }
}
