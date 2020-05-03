package com.fantastic4.desktop.proxy;

import com.fantastic4.desktop.services.ServicesFactory;
import com.fantastic4.desktop.services.SuperService;
import com.fantastic4.desktop.services.custom.SensorService;

import java.rmi.Naming;

public class ProxyHandler implements ServicesFactory {

    private static ProxyHandler proxyHandler;
    private SensorService sensorService;

    private ProxyHandler() {
        try {
            ServicesFactory servicesFactory = (ServicesFactory) Naming.lookup("rmi://localhost:5050/fams");
            sensorService = (SensorService) servicesFactory.getService(ServicesType.SENSOR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProxyHandler getInstance(){
        if (proxyHandler == null)
            proxyHandler = new ProxyHandler();
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServicesType servicesType) throws Exception {
        switch (servicesType) {
            case SENSOR: return sensorService;
            default: return null;
        }
    }
}
