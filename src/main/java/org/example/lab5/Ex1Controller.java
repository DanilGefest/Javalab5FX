package org.example.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Ex1Controller {

    @FXML
    public Button btnToCheckboxer;
    @FXML
    public Button btnToRestaurant;
    @FXML
    public Button btnToCalculator;
    @FXML
    public Button btnToFlag;

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Button switchButton;

    private boolean isTextInFirstField = true;

    @FXML
    public void switchText() {
        if (isTextInFirstField) {
            textField2.setText(textField1.getText());
            textField1.clear();
            switchButton.setText("<----");
        } else {
            textField1.setText(textField2.getText());
            textField2.clear();
            switchButton.setText("---->");
        }
        isTextInFirstField = !isTextInFirstField;
    }
}
