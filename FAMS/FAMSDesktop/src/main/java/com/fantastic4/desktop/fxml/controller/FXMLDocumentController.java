package com.fantastic4.desktop.fxml.controller;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnProfile;
    @FXML
    private Button btnSensors;
    @FXML
    private Button btnRoom;
    @FXML
    private AnchorPane profile,sensors,dashboard,rooms;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
            rooms = FXMLLoader.load(getClass().getResource("roommanager.fxml"));
            sensors = FXMLLoader.load(getClass().getResource("sensormanager.fxml"));
            profile = FXMLLoader.load(getClass().getResource("profile.fxml"));
            dashboard = FXMLLoader.load(getClass().getResource("livedashboard.fxml"));
            setNode(dashboard);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add(node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchDashboard(ActionEvent event) {
        setNode(dashboard);
    }

    @FXML
    private void switchRooms(ActionEvent event) {
        setNode(rooms);
    }

    @FXML
    private void switchSensors(ActionEvent event) {
        setNode(sensors);
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profile);
    }


}