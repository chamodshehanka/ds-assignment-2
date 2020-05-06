package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.desktop.controller.FloorController;
import com.fantastic4.desktop.controller.RoomController;
import com.fantastic4.desktop.main.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import java.io.IOException;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ResourceBundle;
import java.net.URL;

public class AdminRoomRegister implements Initializable{

    @FXML
    private TextField roomRegText;

    @FXML
    private ComboBox<String> roomFloorSelect;

    FloorController floorDTO;
    ObservableList<String> floorData = FXCollections.observableArrayList();

    @FXML
    private void addRoom() throws Exception {

        int selectedFloor =  Integer.parseInt(roomFloorSelect.getValue());

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNo(roomRegText.getText());
        roomDTO.setFloorNo(selectedFloor);

        boolean status = RoomController.addRoom(roomDTO);
        if(status){
            App.setRoot("roommanager");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            floorData = (ObservableList)floorDTO.getAllFloors();
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomFloorSelect.setItems(floorData);
    }

    @FXML
    private void switchToRoomManager() throws IOException {
        App.setRoot("roommanager");
    }

}
