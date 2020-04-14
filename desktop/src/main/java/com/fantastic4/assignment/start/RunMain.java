package com.fantastic4.assignment.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunMain extends Application {

    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
        Scene scene =new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Domino's Management System");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
