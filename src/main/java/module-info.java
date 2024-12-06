module org.example.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens org.example.lab5 to javafx.fxml;
    exports org.example.lab5;
}