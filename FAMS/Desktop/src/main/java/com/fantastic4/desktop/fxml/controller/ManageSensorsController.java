package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.SensorController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageSensorsController implements Initializable {

    @FXML
    public TextField sensorID;

    @FXML
    public TextField floorNo;

    @FXML
    public TextField roomNo;


    @FXML
    private TableView<SensorsTableModel> tblSensors;

    @FXML
    private TableColumn<SensorsTableModel, String> colSensorID;

    @FXML
    private TableColumn<SensorsTableModel, Integer> colFloor;

    @FXML
    private TableColumn<SensorsTableModel, Integer> colRoom;

    private ObservableList<SensorsTableModel> sensorsTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSensorsTable();
    }


    @FXML
    private void addAction() {
        SensorDTO sensorDTO = new SensorDTO(
                sensorID.getText(),
                Integer.parseInt(floorNo.getText()),
                Integer.parseInt(roomNo.getText()),
                0,
                0,
                true

        );

        try {
            boolean isAdded = SensorController.createSensor(sensorDTO);
            if (isAdded){
//                new AlertBuilder("info","ManageCustomer","Customer Add",
//                        "Customer added successfully");
                refreshTableView();

                sensorID.setText("");
                roomNo.setText("");
                floorNo.setText("");
            }else {
//                new AlertBuilder("error","Manage Customer", "Customer Add",
//                        "Customer couldn't add");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteAction() {
        try {
            boolean isDeleted = SensorController.deleteSensor(sensorID.getText());

            if (isDeleted){
//                new AlertBuilder("info","ManageCustomer","Customer Delete",
//                        "Customer deleted successfully");
                refreshTableView();
            }else {
//                new AlertBuilder("error","ManageCustomer","Customer Delete",
//                        "Customer couldn't delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void searchById() {
        try {
            SensorDTO sensorDTO = SensorController.getSensorByID(sensorID.getText());
            if (sensorDTO != null){
                sensorID.setText(sensorDTO.getSensorID());
                floorNo.setText(String.valueOf(sensorDTO.getFloorNo()));
                roomNo.setText(String.valueOf(sensorDTO.getRoomNo()));

            }else {
//                new AlertBuilder("warn","Manage Customer","Customer Search",
//                        "Customer couldn't found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateAction() {
        SensorDTO sensorDTO = new SensorDTO(
                sensorID.getText(),
                Integer.parseInt(floorNo.getText()),
                Integer.parseInt(roomNo.getText()),
                0,
                0,
                true
        );

        try {
            boolean isUpdated = SensorController.updateSensor(sensorDTO);

            if (isUpdated){
//                new AlertBuilder("info","Manage Customer","Customer Update",
//                        "Customer updated successfully");
                refreshTableView();
            }else {
//                new AlertBuilder("info","Manage Customer","Customer Update",
//                        "Customer couldn't update.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSensorsTable(){
        colSensorID.setCellValueFactory(new PropertyValueFactory<>("sensorID"));
        colFloor.setCellValueFactory(new PropertyValueFactory<>("floor"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("room"));

        tblSensors.setItems(sensorsTableModelObservableList);

        try {
            List<SensorDTO> sensorDTOList = SensorController.getAllSensors();
            for (SensorDTO sensorDTO: sensorDTOList
            ) {
                SensorsTableModel sensorsTableModel = new SensorsTableModel();
                sensorsTableModel.setSensorID(sensorDTO.getSensorID());
                sensorsTableModel.setFloor(sensorDTO.getFloorNo());
                sensorsTableModel.setRoom(sensorDTO.getRoomNo());

                sensorsTableModelObservableList.add(sensorsTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void getSelectedItem() {
        String sensor = tblSensors.getSelectionModel().getSelectedItem().getSensorID();
        sensorID.setText(sensor);
        searchById();
    }


    private void refreshTableView(){
        tblSensors.setItems(null);
        sensorsTableModelObservableList.clear();
        loadSensorsTable();
    }
}
