package com.fantastic4.desktop.fxml.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.desktop.controller.SensorController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SensorDataController extends ListCell<SensorDTO>{

    @FXML
    private Text sensorName,floorNo,roomNo,status;
    @FXML
    private ProgressIndicator smokeValue,co2Value;


    @Override
    protected void updateItem(SensorDTO sensorDTO, boolean empty) {
        super.updateItem(sensorDTO, empty);
        if(empty || sensorDTO == null) {

            setText(null);
            setGraphic(null);

        } else {
            FXMLLoader mLLoader = null;
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/fantastic4/desktop/fxml/ui/sensormanager.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            sensorName.setText(sensorDTO.getSensorID());
            floorNo.setText(String.valueOf(sensorDTO.getFloorNo()));
            roomNo.setText(String.valueOf(sensorDTO.getRoomNo()));
            smokeValue.setProgress(sensorDTO.getLatestSmokeLevel()/10.0);
            co2Value.setProgress(sensorDTO.getLatestCO2Level()/10.0);


        }
    }
}
