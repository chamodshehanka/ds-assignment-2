package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.desktop.controller.SensorController;
import com.fantastic4.common.dto.SensorDataDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SensorDataController implements Initializable{

    SensorController sensorController = new SensorController();
    @FXML
    private Text sensorName,floorNo,roomNo,smokeLevel,co2Level,status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
           List<SensorDataDTO> sensorData =  sensorController.getSensorData("S001");
           sensorName.setText(sensorData.get(0).getSensorID());
           floorNo.setText(String.valueOf(sensorData.get(0).getFloorNo()));
           roomNo.setText(String.valueOf(sensorData.get(0).getRoomNo()));
           smokeLevel.setText(String.valueOf(sensorData.get(0).getSmokeLevel()));
           co2Level.setText(String.valueOf(sensorData.get(0).getCo2Level()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
