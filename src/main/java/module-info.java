module org.example.numberguesser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.numberguesser to javafx.fxml;
    exports org.example.numberguesser;
}