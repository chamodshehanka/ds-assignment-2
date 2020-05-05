package com.fantastic4.server.services.impl.custom;

import com.fantastic4.common.dto.FloorDTO;
import com.fantastic4.common.services.custom.FloorService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FloorServiceImpl extends UnicastRemoteObject implements FloorService {

    public FloorServiceImpl() throws RemoteException {
    }

    @Override
    public boolean addFloor(FloorDTO floorDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateFloor(FloorDTO floorDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteFloor(String id) throws Exception {
        return false;
    }

    @Override
    public FloorDTO findFloorByID(String id) throws Exception {
        return null;
    }

    @Override
    public List<FloorDTO> getAllFloors() throws Exception {
        return null;
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
