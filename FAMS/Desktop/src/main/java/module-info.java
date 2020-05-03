module com.fantastic4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    opens com.fantastic4 to javafx.fxml;
    opens com.fantastic4.desktop.main to javafx.graphics;
    opens com.fantastic4.desktop.fxml.controller to javafx.fxml;
    exports com.fantastic4.desktop.fxml.controller;
}