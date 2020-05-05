package com.fantastic4.server.repository;

import com.fantastic4.server.repository.custom.impl.AdminRepositoryImpl;
import com.fantastic4.server.repository.custom.impl.FloorRepositoryImpl;
import com.fantastic4.server.repository.custom.impl.RoomRepositoryImpl;
import com.fantastic4.server.repository.custom.impl.SensorRepositoryImpl;

public class RepositoryFactory {
    public enum RepositoryFactoryTypes{
        SENSOR,
        ADMIN,
        ROOM,
        FLOOR,
        SENSOR_DATA
    }

    private RepositoryFactory() {
    }

    private static RepositoryFactory repositoryFactory;

    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null)
            repositoryFactory = new RepositoryFactory();
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryFactoryTypes repositoryFactoryTypes){
        switch (repositoryFactoryTypes){
            case SENSOR: return new SensorRepositoryImpl();
            case ADMIN: return new AdminRepositoryImpl();
            case ROOM: return new RoomRepositoryImpl();
            case FLOOR: return new FloorRepositoryImpl();
            default: return null;
        }
    }
}
