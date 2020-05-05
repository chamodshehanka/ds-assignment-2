package com.fantastic4.desktop.services.custom;

import com.fantastic4.desktop.dto.SensorDTO;
import com.fantastic4.desktop.dto.SensorDataDTO;
import com.fantastic4.desktop.services.SuperService;

import java.util.List;

public interface SensorService extends SuperService {

    boolean addSensor(SensorDTO sensorDTO) throws Exception;

    boolean updateSensor(SensorDTO sensorDTO) throws Exception;

    boolean deleteSensor(String sensorID) throws Exception;

    SensorDTO findSensorByID(String sensorID) throws Exception;

    List<SensorDTO> getAllSensors() throws Exception;

    List<SensorDataDTO> getSensorData(String sensorID) throws Exception;
    // Add Observers later

}
