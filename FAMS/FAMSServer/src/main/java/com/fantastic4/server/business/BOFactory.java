package com.fantastic4.server.business;

import com.fantastic4.server.business.custom.impl.AdminBOImpl;
import com.fantastic4.server.business.custom.impl.FloorBOImpl;
import com.fantastic4.server.business.custom.impl.RoomBOImpl;
import com.fantastic4.server.business.custom.impl.SensorBOImpl;

public class BOFactory {
    public enum BOTypes{
        SENSOR,
        ADMIN,
        ROOM,
        FLOOR,
        SENSOR_DATA
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
            case ADMIN: return new AdminBOImpl();
            case ROOM: return new RoomBOImpl();
            case FLOOR: return new FloorBOImpl();
            default:return null;
        }
    }
}
