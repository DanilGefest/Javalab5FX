package org.example.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Ex4Controller {
    @FXML
    public Button btnToSwitcher;
    @FXML
    public Button btnToCheckboxer;
    @FXML
    public Button btnToRestaurant;
    @FXML
    public Button btnToFlag;

    @FXML private Label lblResult;

    private double num1 = 0;
    private String operator = "+";

    public void init(Stage stage) {
        // Больше не нужно обрабатывать перемещение окна или кнопки управления окном
    }

    @FXML
    void onNumberClicked(MouseEvent event) {
        int value = Integer.parseInt(((Pane)event.getSource()).getId().replace("btn", ""));
        lblResult.setText(Double.parseDouble(lblResult.getText()) == 0
                ? String.valueOf((double) value)
                : String.valueOf(Double.parseDouble(lblResult.getText()) * 10 + value));
    }

    @FXML
    void onSymbolClicked(MouseEvent event) {
        String symbol = ((Pane)event.getSource()).getId().replace("btn", "");
        if(symbol.equals("Equals")) {
            double num2 = Double.parseDouble(lblResult.getText());
            switch (operator) {
                case "+" -> lblResult.setText((num1 + num2) + "");
                case "-" -> lblResult.setText((num1 - num2) + "");
                case "*" -> lblResult.setText((num1 * num2) + "");
                case "/" -> {
                    if (num2 == 0) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);  // Тип предупреждения
                        alert.setTitle("Ошибка деления");
                        alert.setHeaderText(null);  // Можно оставить заголовок пустым
                        alert.setContentText("Невозможно делить на ноль!");  // Текст предупреждения

                        alert.showAndWait();  // Показать окно и дождаться закрытия
                        lblResult.setText((String.valueOf(num1)));
                    } else {
                        lblResult.setText((num1 / num2) + "");
                    }
                }
            }
            operator = ".";
        } else if(symbol.equals("Clear")) {
            lblResult.setText(String.valueOf(0.0));
            operator = ".";
        } else {
            switch (symbol) {
                case "Plus" -> operator = "+";
                case "Minus" -> operator = "-";
                case "Multiply" -> operator = "*";
                case "Divide" -> operator = "/";
            }
            num1 = Double.parseDouble(lblResult.getText());
            lblResult.setText(String.valueOf(0.0));
        }
    }


}
