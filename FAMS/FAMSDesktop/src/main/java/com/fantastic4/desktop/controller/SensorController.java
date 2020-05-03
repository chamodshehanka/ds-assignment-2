package com.fantastic4.desktop.controller;

import com.fantastic4.desktop.dto.SensorDTO;
import com.fantastic4.desktop.services.ServicesFactory;
import com.fantastic4.desktop.services.custom.SensorService;
import com.fantastic4.desktop.proxy.ProxyHandler;

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

}
