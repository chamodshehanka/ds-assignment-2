package com.fantastic4.desktop.controller;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.desktop.proxy.ProxyHandler;
import com.fantastic4.common.services.ServicesFactory;
import com.fantastic4.common.services.custom.SensorService;

import java.util.List;

public class SensorController {

    private static SensorService sensorService;

    public static boolean createSensor(SensorDTO sensorDTO) throws Exception {
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.addSensor(sensorDTO);
    }

    public static boolean updateSensor(SensorDTO sensorDTO) throws Exception {
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.updateSensor(sensorDTO);
    }

    public static List<SensorDTO> getAllSensors() throws Exception {
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.getAllSensors();
    }


    public static SensorDTO getSensorByID(String id) throws Exception {
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.findSensorByID(id);
    }

    public static boolean deleteSensor(String id) throws Exception {
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.deleteSensor(id);
    }

    public List<SensorDataDTO> getSensorData(String sensorID) throws Exception {
        System.out.println("Inside getSensorData Controller");
        sensorService = (SensorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.SENSOR);

        return sensorService.getSensorData(sensorID);
    }

}
