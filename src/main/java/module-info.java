module com.example.quizzz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizzz to javafx.fxml;
    exports com.example.quizzz;
}