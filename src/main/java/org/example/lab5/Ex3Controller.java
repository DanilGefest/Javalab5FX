package org.example.lab5;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Ex3Controller {

    @FXML
    public Button btnToSwitcher;
    @FXML
    public Button btnToCheckboxer;
    @FXML
    public Button btnToCalculator;
    @FXML
    public Button btnToFlag;

    @FXML
    private VBox dishListVBox;

    private final List<Dish> dishes = List.of(
            new Dish("Спатен 0,5л", 500),
            new Dish("Пельмени жареные", 400),
            new Dish("Сырное ассорти", 600)
    );

    private final List<SelectedDish> selectedDishes = new ArrayList<>();

    @FXML
    public void initialize() {
        for (Dish dish : dishes) {
            addDishToMenu(dish);
        }
    }

    private void addDishToMenu(Dish dish) {
        HBox dishRow = new HBox(10);
        Label nameLabel = new Label(dish.getName());
        Label priceLabel = new Label(dish.getPrice() + " рублёв");

        TextField portionField = new TextField();
        portionField.setPromptText("Введите кол-во");
        portionField.setDisable(false);

        // Убираем второй лишний слушатель
        portionField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Разрешаем только цифры, включая 0
            if (!newValue.matches("\\d*")) {
                portionField.setText(oldValue);
            } else {
                updateSelectedDish(dish, newValue);
            }
        });

        dishRow.getChildren().addAll(nameLabel, priceLabel, portionField);
        dishListVBox.getChildren().add(dishRow);
    }

    private void updateSelectedDish(Dish dish, String newValue) {
        int quantity = 0;
        if (!newValue.isEmpty()) {
            quantity = Integer.parseInt(newValue);
        }

        boolean found = false;
        for (int i = 0; i < selectedDishes.size(); i++) {
            if (selectedDishes.get(i).getDish().equals(dish)) {
                if (quantity > 0) {
                    selectedDishes.get(i).setPortionCount(quantity);
                } else {
                    selectedDishes.remove(i);
                }
                found = true;
                break;
            }
        }
        if (quantity > 0 && !found) {
            selectedDishes.add(new SelectedDish(dish, quantity));
        }
    }

    @FXML
    private void processOrder() {
        if (selectedDishes.isEmpty()) {
            showWarningDialog("Пожалуйста, выберите блюдо.");
            return;
        }

        showOrderSummary();
    }

    private void showOrderSummary() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Итоговый чек");

        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-padding: 10; -fx-font-size: 14px;");

        Label title = new Label("Ваш заказ:");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #333333;");
        vbox.getChildren().add(title);

        double total = 0;
        for (SelectedDish selectedDish : selectedDishes) {
            Dish dish = selectedDish.getDish();
            int portionCount = selectedDish.getPortionCount();
            double pricePerPortion = dish.getPrice();
            double totalPriceForDish = pricePerPortion * portionCount;

            Label orderItem = new Label(dish.getName() + " : " + pricePerPortion + " рублёв x " + portionCount + " = " + totalPriceForDish + " рублёв");
            vbox.getChildren().add(orderItem);

            total += totalPriceForDish;
        }

        Label totalLabel = new Label("Итого: " + total + " деревянных");
        vbox.getChildren().add(totalLabel);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);

        vbox.autosize();
        stage.sizeToScene(); // Адаптивность окна к содержимому
        stage.show();
    }

    private void showWarningDialog(String message) {
        Stage warningStage = new Stage();
        warningStage.initModality(Modality.APPLICATION_MODAL);
        warningStage.setTitle("Предупреждение");

        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-padding: 20; -fx-font-size: 14px;");

        Label warningLabel = new Label(message);
        Button okButton = new Button("OK");
        okButton.setOnAction(e -> warningStage.close());

        vbox.getChildren().addAll(warningLabel, okButton);

        Scene scene = new Scene(vbox, 300, 100);
        warningStage.setScene(scene);
        warningStage.show();
    }

    private static class SelectedDish {
        private final Dish dish;
        private int portionCount;

        public SelectedDish(Dish dish, int portionCount) {
            this.dish = dish;
            this.portionCount = portionCount;
        }

        public Dish getDish() {
            return dish;
        }

        public int getPortionCount() {
            return portionCount;
        }

        public void setPortionCount(int portionCount) {
            this.portionCount = portionCount;
        }
    }
}

class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
