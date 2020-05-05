package com.fantastic4.desktop.controller;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.common.services.ServicesFactory;
import com.fantastic4.common.services.custom.FloorService;
import com.fantastic4.desktop.proxy.ProxyHandler;

import java.util.List;

public class FloorController {

    private static FloorService floorService;

    public static boolean addFloor(FloorDTO floorDTO) throws Exception {
        floorService = (FloorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.FLOOR);

        return floorService.addFloor(floorDTO);
    }

    public static boolean updateFloor(FloorDTO floorDTO) throws Exception {
        floorService = (FloorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.FLOOR);

        return floorService.updateFloor(floorDTO);
    }

    public static boolean deleteFloor(String id) throws Exception {
        floorService = (FloorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.FLOOR);

        return floorService.deleteFloor(id);
    }

    public static FloorDTO getFloorByID(String id) throws Exception {
        floorService = (FloorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.FLOOR);

        return floorService.findFloorByID(id);
    }

    public static List<FloorDTO> getAllFloors() throws Exception {
        floorService = (FloorService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.FLOOR);

        return floorService.getAllFloors();
    }
}
