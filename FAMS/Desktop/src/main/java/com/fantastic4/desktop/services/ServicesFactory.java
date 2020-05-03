package com.fantastic4.desktop.services;

import java.rmi.Remote;

public interface ServicesFactory extends Remote {
    enum ServicesType {
        SENSOR
    }

    SuperService getService(ServicesType servicesType) throws Exception;
}
