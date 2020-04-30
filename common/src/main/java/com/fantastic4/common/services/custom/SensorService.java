package com.fantastic4.common.services.custom;

import src.com.fantastic4.common.dto.SensorDTO;
import src.com.fantastic4.common.services.SuperService;

import java.util.List;

public interface SensorService extends SuperService {

    boolean addSensor(SensorDTO sensorDTO) throws Exception;

    boolean updateSensor(SensorDTO sensorDTO) throws Exception;

    boolean deleteSensor(String sensorID) throws Exception;

    SensorDTO findSensorByID(String sensorID) throws Exception;

    List<SensorDTO> getAllSensors() throws Exception;

    // Add Observers later

}
