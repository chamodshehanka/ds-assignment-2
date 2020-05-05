package com.fantastic4.server.business.custom.impl;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.server.business.custom.SensorBO;
import com.fantastic4.server.repository.RepositoryFactory;
import com.fantastic4.server.repository.custom.SensorRepository;

import java.util.List;

public class SensorBOImpl implements SensorBO {

    private final SensorRepository sensorRepository;

    public SensorBOImpl() {
        sensorRepository = (SensorRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.SENSOR);
    }

    @Override
    public boolean addSensor(SensorDTO sensorDTO) throws Exception {
        return sensorRepository.save(sensorDTO);
    }

    @Override
    public boolean updateSensor(SensorDTO sensorDTO) throws Exception {
        return sensorRepository.update(sensorDTO);
    }

    @Override
    public boolean deleteSensor(String sensorID) throws Exception {
        return sensorRepository.delete(sensorID);
    }

    @Override
    public SensorDTO getSensorByID(String sensorID) throws Exception {
        return sensorRepository.findById(sensorID);
    }

    @Override
    public List<SensorDTO> getAllSensors() throws Exception {
        return sensorRepository.findAll();
    }

    @Override
    public List<SensorDataDTO> getSensorData(String sensorID) throws Exception {
        return null;
    }
}
