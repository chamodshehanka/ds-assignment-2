package com.fantastic4.server.repository;

import com.fantastic4.server.repository.custom.impl.SensorRepositoryImpl;

public class RepositoryFactory {
    public enum RepositoryFactoryTypes{
        SENSOR
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
            default: return null;
        }
    }
}
