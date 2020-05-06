package com.fantastic4.desktop.controller;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.services.ServicesFactory;
import com.fantastic4.common.services.custom.RoomService;
import com.fantastic4.desktop.proxy.ProxyHandler;

import java.util.List;

public class RoomController {

    private static RoomService roomService;

    public static boolean addRoom(RoomDTO roomDTO) throws Exception {
        roomService = (RoomService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ROOM);

        return roomService.addRoom(roomDTO);
    }

    public static boolean updateRoom(RoomDTO roomDTO) throws Exception {
        roomService = (RoomService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ROOM);

        return roomService.updateRoom(roomDTO);
    }

    public static boolean deleteRoom(String id) throws Exception {
        roomService = (RoomService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ROOM);

        return roomService.deleteRoom(id);
    }

    public static RoomDTO getRoomByID(String id) throws Exception {
        roomService = (RoomService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ROOM);

        return roomService.findRoomByID(id);
    }

    public static List<RoomDTO> getAllRooms() throws Exception {
        roomService = (RoomService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ROOM);

        return roomService.getAllRooms();
    }

}
