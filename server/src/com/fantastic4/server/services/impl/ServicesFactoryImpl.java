package com.fantastic4.server.services.impl;

import com.fantastic4.server.common.services.ServicesFactory;
import com.fantastic4.server.common.services.SuperService;
import com.fantastic4.server.services.impl.custom.SensorServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicesFactoryImpl extends UnicastRemoteObject implements ServicesFactory {
    private static ServicesFactory servicesFactory;

    private ServicesFactoryImpl() throws RemoteException {
    }

    public static ServicesFactory getInstance()throws RemoteException{
        if (servicesFactory == null)
            servicesFactory = new ServicesFactoryImpl();
        return servicesFactory;
    }

    @Override
    public SuperService getService(ServicesType servicesType) throws Exception {
        switch (servicesType){
            case SENSOR: return new SensorServiceImpl();
            default: return null;
        }
    }
}
