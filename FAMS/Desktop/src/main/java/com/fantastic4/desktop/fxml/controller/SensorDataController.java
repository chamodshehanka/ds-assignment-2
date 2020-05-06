package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.SensorController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SensorDataController implements Initializable{

    @FXML
    private Text sensorName,floorNo,roomNo,status;
    @FXML
    private ProgressIndicator smokeValue,co2Value;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            List<SensorDTO> sensors = SensorController.getAllSensors();
            for (SensorDTO sensor:sensors
            ) {
                System.out.println(sensor.getSensorID());
            }

           sensorName.setText(sensors.get(1).getSensorID());
           floorNo.setText(String.valueOf(sensors.get(1).getFloorNo()));
           roomNo.setText(String.valueOf(sensors.get(1).getRoomNo()));
           smokeValue.setProgress(sensors.get(1).getLatestSmokeLevel()/10.0);
           co2Value.setProgress(sensors.get(1).getLatestCO2Level()/10.0);
           if(sensors.get(1).getLatestSmokeLevel() >= 5 || sensors.get(1).getLatestCO2Level() >= 5){
               status.setText("Danger");
               status.setFill(Color.RED);
            }else{
               status.setText("Normal");
               status.setFill(Color.GREEN);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
