package com.fantastic4.desktop.proxy;

import com.fantastic4.common.services.ServicesFactory;
import com.fantastic4.common.services.SuperService;
import com.fantastic4.common.services.custom.SensorService;

public class ProxyHandler implements ServicesFactory {

    private static ProxyHandler proxyHandler;
    private SensorService sensorService;

    private ProxyHandler() {
        
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
