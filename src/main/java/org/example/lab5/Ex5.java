package org.example.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Ex5 extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        Parent root = FXMLLoader.load(Objects.requireNonNull(Ex5.class.getResource("Ex5Interface.fxml")));
        primaryStage.setTitle("Задание 5");
        primaryStage.setScene(new Scene(root, 250, 220));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
