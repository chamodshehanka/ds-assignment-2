package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.FloorController;
import com.fantastic4.desktop.controller.RoomController;
import com.fantastic4.desktop.controller.SensorController;
import com.fantastic4.desktop.main.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSensorUpdate implements Initializable {

    SensorController sensorController;
    SensorDTO sensorDTO;

    FloorController floorDTO;
    RoomController roomDTO;

    ObservableList<String> floorData = FXCollections.observableArrayList();
    ObservableList<String> roomData = FXCollections.observableArrayList();

    @FXML
    TextField sensorNameText;

    @FXML
    private ComboBox sensorFloorSelect, sensorRoomSelect;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    private void updateSensor() throws Exception {

        int selectedFloor =  Integer.parseInt((String) sensorFloorSelect.getValue());
        int selectedRoom =  Integer.parseInt((String) sensorRoomSelect.getValue());

        SensorDTO sensorDTO = new SensorDTO();
        sensorDTO.setSensorID(sensorNameText.getText());
        sensorDTO.setFloorNo(selectedFloor);
        sensorDTO.setRoomNo(selectedRoom);

        boolean status = SensorController.updateSensor(sensorDTO);
        if(status){
            App.setRoot("roommanager");
        }
    }

    public void getSensorID(String id) throws Exception {
        sensorDTO = sensorController.getSensorByID(id);
        sensorNameText.setText(sensorDTO.getSensorID());
        sensorFloorSelect.setValue(sensorDTO.getFloorNo());
        sensorRoomSelect.setValue(sensorDTO.getRoomNo());

    }

    @FXML
    private void switchToRoomManager() throws IOException {
        App.setRoot("roommanager");
    }
}
