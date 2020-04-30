package com.fantastic4.server.business;

import com.fantastic4.server.business.custom.impl.SensorBOImpl;

public class BOFactory {
    public enum BOTypes{
        SENSOR
    }

    private BOFactory() {
    }

    private static BOFactory boFactory;

    public static BOFactory getInstance(){
        if (boFactory == null)
            boFactory = new BOFactory();
        return boFactory;
    }

    public SuperBO getBOFactory(BOTypes boTypes){
        switch (boTypes){
            case SENSOR: return new SensorBOImpl();
            default:return null;
        }
    }
}
