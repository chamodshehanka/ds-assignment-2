package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.desktop.controller.FloorController;
import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;

public class AdminFloorResgister implements Initializable{

    @FXML
    private TextField floorNoText;

    @FXML
    private void addFloor() throws Exception{

        int floor =  Integer.parseInt(floorNoText.getText());
        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setFloorNo(floor);

        boolean status = FloorController.addFloor(floorDTO);
        if(status){
            App.setRoot("roommanager");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void switchToRoomManager() throws IOException {
        App.setRoot("roommanager");
    }
}
