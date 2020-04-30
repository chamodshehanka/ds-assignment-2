package com.fantastic4.server.repository.custom.impl;

import com.fantastic4.server.entity.Sensor;
import com.fantastic4.server.repository.custom.SensorRepository;
import com.fantastic4.server.repository.impl.SuperRepositoryImpl;

public class SensorRepositoryImpl extends SuperRepositoryImpl<Sensor, String> implements SensorRepository {

    public SensorRepositoryImpl() {
        System.out.println("Sensor Repository Impl " + this);
    }
}
