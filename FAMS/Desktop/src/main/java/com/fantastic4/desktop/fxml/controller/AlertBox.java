package com.fantastic4.desktop.fxml.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String msg) {
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMaxWidth(300);
        stage.setMaxHeight(250);

        Label label = new Label();
        label.setText(msg);
        Button close = new Button("OK");
        close.setOnAction(e -> stage.close());

        VBox box = new VBox(10);
        box.getChildren().addAll(label, close);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
