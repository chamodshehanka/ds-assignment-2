package com.fantastic4.server.services.impl.custom;

import com.fantastic4.common.dto.RoomDTO;
import com.fantastic4.common.services.custom.RoomService;
import com.fantastic4.server.business.BOFactory;
import com.fantastic4.server.business.custom.RoomBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RoomServiceImpl extends UnicastRemoteObject implements RoomService {

    private final RoomBO roomBO;

    public RoomServiceImpl() throws RemoteException {
        roomBO = (RoomBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.ROOM);
    }


    @Override
    public boolean addRoom(RoomDTO roomDTO) throws Exception {
        return roomBO.addRoom(roomDTO);
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        return roomBO.updateRoom(roomDTO);
    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        return roomBO.deleteRoom(id);
    }

    @Override
    public RoomDTO findRoomByID(String id) throws Exception {
        return roomBO.findRoomByID(id);
    }

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        return roomBO.getAllRooms();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean release(Object id) throws Exception {
        return false;
    }
}
