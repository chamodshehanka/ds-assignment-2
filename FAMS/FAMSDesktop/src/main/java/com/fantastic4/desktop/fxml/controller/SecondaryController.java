package com.fantastic4.desktop.fxml.controller;

import java.io.IOException;

import com.fantastic4.desktop.main.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class SecondaryController {
    @FXML
    private Pane pnl_home,pnl_sensors,pnl_rooms;
    @FXML
    private Button btn_home,btn_manage_sensors,btn_manage_rooms;

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource() == btn_home){
            pnl_home.toFront();
        }
        else if (event.getSource() == btn_manage_rooms){
            pnl_rooms.toFront();
        }
        else if(event.getSource() == btn_manage_sensors){
            pnl_sensors.toFront();
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}