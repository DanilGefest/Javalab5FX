package org.example.lab5;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Ex5Controller {

    @FXML
    public Button btnToSwitcher;
    @FXML
    public Button btnToCheckboxer;
    @FXML
    public Button btnToRestaurant;
    @FXML
    public Button btnToCalculator;

    @FXML
    private ComboBox<String> colorComboBox1;
    @FXML
    private ComboBox<String> colorComboBox2;
    @FXML
    private ComboBox<String> colorComboBox3;

    private final String[] colors = {"Белый", "Красный", "Зеленый", "Голубой", "Желтый"};

    @FXML
    public void initialize() {
        initializeComboBox(colorComboBox1);
        initializeComboBox(colorComboBox2);
        initializeComboBox(colorComboBox3);
    }

    private void initializeComboBox(ComboBox<String> comboBox) {
        comboBox.setItems(FXCollections.observableArrayList(colors));
        comboBox.setValue("Белый");
    }

    @FXML
    private void showSelectedColors() {
        String color1 = colorComboBox1.getValue();
        String color2 = colorComboBox2.getValue();
        String color3 = colorComboBox3.getValue();

        String selectedColors = color1 + ", " + color2 + ", " + color3;

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Выбранные цвета");
        alert.setHeaderText(null);
        alert.setContentText(selectedColors);

        alert.showAndWait();
    }
}
