package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.FloorController;
import com.fantastic4.desktop.controller.RoomController;
import com.fantastic4.desktop.controller.SensorController;
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

public class AdminSensorRegister implements Initializable {

    @FXML
    private TextField sensorNameText;

    @FXML
    private ComboBox sensorFloorSelect, sensorRoomSelect;

    FloorController floorDTO;
    RoomController roomDTO;

    ObservableList<String> floorData = FXCollections.observableArrayList();
    ObservableList<String> roomData = FXCollections.observableArrayList();

    @FXML
    private void addSensor() throws Exception {

        int selectedFloor =  Integer.parseInt((String) sensorFloorSelect.getValue());
        int selectedRoom =  Integer.parseInt((String) sensorRoomSelect.getValue());

        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensorID(sensorNameText.getText());
        sensorDTO.setFloorNo(selectedFloor);
        sensorDTO.setRoomNo(selectedRoom);

        boolean status = SensorController.createSensor(sensorDTO);
        if(status){
            App.setRoot("roommanager");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            floorData = (ObservableList)floorDTO.getAllFloors();
            roomData = (ObservableList)roomDTO.getAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sensorFloorSelect.setItems(floorData);
        sensorRoomSelect.setItems(roomData);
    }

    @FXML
    private void switchToRoomManager() throws IOException {
        App.setRoot("roommanager");
    }
}
