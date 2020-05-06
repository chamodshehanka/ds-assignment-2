package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.SensorController;
import com.fantastic4.desktop.main.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class roommanager implements Initializable {

    @FXML
    TableView tableView;

    @FXML
    TextField searchSensorText;

    @FXML
    Button editSensor, deleteSensor, addSensor, addRoom, addFloor;

    @FXML
    TableColumn id, sensorName, roomNumber, floorNumber;

    SensorController sensorController;
    AlertBox alertBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SensorController sensorController = null;

        TableColumn id = new TableColumn("id");
        TableColumn sensor = new TableColumn("sensorName");
        TableColumn room = new TableColumn("roomNumber");
        TableColumn floor = new TableColumn("floorNumber");
        tableView.getColumns().addAll(id, sensor, room, floor);

        ObservableList<SensorDTO> sensorDetails = FXCollections.observableArrayList();
        try {
            sensorDetails = (ObservableList) sensorController.getAllSensors();
        } catch (Exception e) {
            e.printStackTrace();
        }
        id.setCellValueFactory(new PropertyValueFactory<SensorDTO, String>("id"));
        sensor.setCellValueFactory(new PropertyValueFactory<SensorDTO, String>("name"));
        room.setCellValueFactory(new PropertyValueFactory<SensorDTO, String>("room"));
        floor.setCellValueFactory(new PropertyValueFactory<SensorDTO, String>("floor"));

        tableView.setItems(sensorDetails);

    }

    @FXML
    private void switchToAddRoom() throws IOException {
        App.setRoot("AdminRoomRegister");
    }

    @FXML
    private void switchToAddFloor() throws IOException{
        App.setRoot("AdminFloorResgister");
    }

    @FXML
    private void switchToAddSensor() throws IOException{
        App.setRoot("AdminSensorRegister");
    }

    @FXML
    private void switchToDeleteSensor() throws Exception {
        String sensor = searchSensorText.getText();
        boolean result = sensorController.deleteSensor(sensor);
        if(result) {
            alertBox.display("Deleted","Sensor Successfully deleted!");
        }

    }

    @FXML
    private void switchToEditSensor() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/AdminSensorUpdate.fxml"));
        Parent root = loader.load();

        AdminSensorUpdate sensorUpdate = loader.getController();
        sensorUpdate.getSensorID(searchSensorText.getText());

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}