package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.SensorController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SensorDataController implements Initializable{

    @FXML
    private Text sensorName,floorNo,roomNo,smokeLevel,co2Level,status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            List<SensorDTO> sensors = SensorController.getAllSensors();
            for (SensorDTO sensor:sensors
            ) {
                System.out.println(sensor.getSensorID());
            }
           //List<SensorDataDTO> sensorData =  sensorController.getSensorData("S001");
           sensorName.setText(sensors.get(0).getSensorID());
           floorNo.setText(String.valueOf(sensors.get(0).getFloorNo()));
           roomNo.setText(String.valueOf(sensors.get(0).getRoomNo()));
           smokeLevel.setText(String.valueOf(0));
           co2Level.setText(String.valueOf(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}