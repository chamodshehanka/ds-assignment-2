module com.fantastic4.desktop{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.rmi;

    opens com.fantastic4.desktop to javafx.fxml, javafx.graphics;
    exports com.fantastic4.desktop.fxml.controller;
}