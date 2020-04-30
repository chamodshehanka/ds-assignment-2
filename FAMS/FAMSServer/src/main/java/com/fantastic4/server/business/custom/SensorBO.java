package com.fantastic4.server.business.custom;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.server.business.SuperBO;

import java.util.List;

public interface SensorBO extends SuperBO {

    boolean addSensor(SensorDTO sensorDTO) throws Exception;

    boolean updateSensor(SensorDTO sensorDTO) throws Exception;

    boolean deleteSensor(String sensorID) throws Exception;

    SensorDTO getSensorByID(String sensorID) throws Exception;

    List<SensorDTO> getAllSensors() throws Exception;

}
