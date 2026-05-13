module com.example.oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.oop to javafx.fxml;
    exports com.example.oop;
    exports com.example.oop.GUI;
    opens com.example.oop.GUI to javafx.fxml;
    exports com.example.oop.GUI.authentication;
    opens com.example.oop.GUI.authentication to javafx.fxml;
    exports com.example.oop.logic;
    opens com.example.oop.logic to javafx.fxml;
    exports com.example.oop.logic.database;
    opens com.example.oop.logic.database to javafx.fxml;
    exports com.example.oop.GUI.trip;
    opens com.example.oop.GUI.trip to javafx.fxml;
}