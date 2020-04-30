package com.fantastic4.server.services.impl.custom;

import com.fantastic4.server.business.BOFactory;
import com.fantastic4.server.business.custom.SensorBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SensorServiceImpl extends UnicastRemoteObject implements SensorService {

    private SensorBO sensorBO;
//    public static final


    public SensorServiceImpl() throws RemoteException {
        sensorBO = (SensorBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.SENSOR);
    }

    @Override
    public boolean addSensor(SensorDTO sensorDTO) throws Exception {
        return sensorBO.addSensor(sensorDTO);
    }

    @Override
    public boolean updateSensor(SensorDTO sensorDTO) throws Exception {
        return sensorBO.updateSensor(sensorDTO);
    }

    @Override
    public boolean deleteSensor(String sensorID) throws Exception {
        return sensorBO.deleteSensor(sensorID);
    }

    @Override
    public SensorDTO findSensorByID(String sensorID) throws Exception {
        return sensorBO.getSensorByID(sensorID);
    }

    @Override
    public List<SensorDTO> getAllSensors() throws Exception {
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
