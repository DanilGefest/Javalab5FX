package org.example.lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class Ex2Controller {
    @FXML
    public Button btnToSwitcher;
    @FXML
    public Button btnToRestaurant;
    @FXML
    public Button btnToCalculator;
    @FXML
    public Button btnToFlag;

    @FXML
    private ImageView header;
    @FXML
    private ImageView body;
    @FXML
    private ImageView footer;
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;

    public void handleCheckboxAction(ActionEvent event) {

        CheckBox selectedCheckbox = (CheckBox) event.getSource();

        if (selectedCheckbox.equals(checkbox1)) {
            header.setVisible(selectedCheckbox.isSelected());
        } else if (selectedCheckbox.equals(checkbox2)) {
            body.setVisible(selectedCheckbox.isSelected());
        } else if (selectedCheckbox.equals(checkbox3)) {
            footer.setVisible(selectedCheckbox.isSelected());
        }
    }


}
