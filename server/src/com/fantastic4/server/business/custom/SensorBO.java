package com.fantastic4.server.business.custom;

import com.fantastic4.server.business.SuperBO;
import com.fantastic4.server.common.dto.SensorDTO;

import java.util.List;

public interface SensorBO extends SuperBO {

    boolean addSensor(SensorDTO sensorDTO) throws Exception;

    boolean updateSensor(SensorDTO sensorDTO) throws Exception;

    boolean deleteSensor(String sensorID) throws Exception;

    SensorDTO getSensorByID(String sensorID) throws Exception;

    List<SensorDTO> getAllSensors() throws Exception;

}
