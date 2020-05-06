package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.AdminController;
import com.fantastic4.desktop.controller.RoomController;
import com.fantastic4.desktop.controller.SensorController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class LiveDashboardController implements Initializable {


    @FXML
    private Text totalSensors,inactiveSensors,totalAdmins,totalRooms;

    @FXML
    private TableView<SensorTableModel> tblSensor;

    @FXML
    private TableColumn<SensorTableModel, String> colSensorID;

    @FXML
    private TableColumn<SensorTableModel, Integer> colFloor;

    @FXML
    private TableColumn<SensorTableModel, String> colRoom;

    @FXML
    private TableColumn<SensorTableModel, Integer> colSmoke;

    @FXML
    private TableColumn<SensorTableModel, Integer> colCO2;

    @FXML
    private TableColumn<SensorTableModel, String> colStatus;

    @FXML
    private TableColumn<SensorTableModel, String> colSensorStatus;


    private List<SensorDTO> iSensors = new ArrayList<>();
    private List<SensorDTO> tSensors = new ArrayList<>();
    private List<RoomDTO> tRooms = new ArrayList<>();
    private List<AdminDTO> tAdmins = new ArrayList<>();
    private ObservableList<SensorTableModel> sensorTableModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            tSensors = SensorController.getAllSensors();
            for (SensorDTO sensor:tSensors
                 ) {
                System.out.println(sensor.getSensorID());
                if(sensor.getStatus() == false){
                    iSensors.add(sensor);
                }
            }
            //tAdmins = AdminController.getAllAdmins();
            //tRooms = RoomController.getAllRooms();

            totalSensors.setText(Integer.toString(tSensors.size()));
            totalRooms.setText(Integer.toString(tRooms.size()));
            totalAdmins.setText(Integer.toString(tAdmins.size()));
            inactiveSensors.setText(Integer.toString(iSensors.size()));

            loadSensorTableView();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadSensorTableView(){
        colSensorID.setCellValueFactory(new PropertyValueFactory<>("sensorID"));
        colFloor.setCellValueFactory(new PropertyValueFactory<>("floor"));
        colRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        colSmoke.setCellValueFactory(new PropertyValueFactory<>("smoke"));
        colCO2.setCellValueFactory(new PropertyValueFactory<>("CO2"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colSensorStatus.setCellValueFactory(new PropertyValueFactory<>("sensorStatus"));

        tblSensor.setItems(sensorTableModelObservableList);

        try {
            List<SensorDTO> sensorDTOList = SensorController.getAllSensors();
            for (SensorDTO sensorDTO: sensorDTOList
            ) {
                SensorTableModel sensorTableModel = new SensorTableModel();
                sensorTableModel.setSensorID(sensorDTO.getSensorID());
                sensorTableModel.setFloor(sensorDTO.getFloorNo());
                sensorTableModel.setRoom(String.valueOf(sensorDTO.getRoomNo()));
                sensorTableModel.setSmoke(sensorDTO.getLatestSmokeLevel());
                sensorTableModel.setCO2(sensorDTO.getLatestCO2Level());
                if(sensorDTO.getLatestSmokeLevel() >= 5 || sensorDTO.getLatestCO2Level() >= 5){
                    sensorTableModel.setStatus("DANGER");
                }else{
                    sensorTableModel.setStatus("NORMAL");
                }
                if(sensorDTO.getStatus()==true){
                    sensorTableModel.setSensorStatus("ACTIVE");
                }else{
                    sensorTableModel.setSensorStatus("INACTIVE");
                }



                sensorTableModelObservableList.add(sensorTableModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshTableView(){
        tblSensor.setItems(null);
        sensorTableModelObservableList.clear();
        loadSensorTableView();
    }

    @FXML
    private void getSelectedItem() {
        String branchId = tblSensor.getSelectionModel().getSelectedItem().getSensorID();
    }
}
