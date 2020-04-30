package com.fantastic4.common.services;

import java.rmi.Remote;

public interface ServicesFactory extends Remote {
    enum ServicesType {
        SENSOR
    }

    SuperService getService(ServicesType servicesType) throws Exception;
}
