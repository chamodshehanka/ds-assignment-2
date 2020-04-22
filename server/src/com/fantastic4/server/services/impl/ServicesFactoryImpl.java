package com.fantastic4.server.services.impl;

import com.fantastic4.server.common.services.ServicesFactory;
import com.fantastic4.server.common.services.SuperService;

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
//            case ADMIN: return new AdminServiceImpl();
//            case RESERVATION: return new ReservationServiceImpl();
//            case RECEPTION: return new ReceptionServiceImpl();
//            case CUSTOMER: return new CustomerServiceImpl();
//            case VEHICLE: return new VehicleServiceImpl();
//            case PAYMENT: return new PaymentServiceImpl();
//            case DRIVER: return new DriverServiceImpl();
//            case BRANCH: return new BranchServiceImpl();
            default: return null;
        }
    }
}
