package org.example.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ex4 extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(Ex4.class.getResource("Ex4Interface.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Задание 4");
        ((Ex4Controller) loader.getController()).init(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
