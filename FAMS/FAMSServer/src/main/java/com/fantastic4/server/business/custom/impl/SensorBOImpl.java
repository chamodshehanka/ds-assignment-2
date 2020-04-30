package com.fantastic4.server.business.custom.impl;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.server.business.custom.SensorBO;
import com.fantastic4.server.entity.Sensor;
import com.fantastic4.server.repository.RepositoryFactory;
import com.fantastic4.server.repository.custom.SensorRepository;
import com.fantastic4.server.resources.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SensorBOImpl implements SensorBO {

    private final SensorRepository sensorRepository;

    public SensorBOImpl() {
        sensorRepository = (SensorRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.SENSOR);
    }

    @Override
    public boolean addSensor(SensorDTO sensorDTO) throws Exception {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            sensorRepository.setSession(session);

            Sensor sensor = new Sensor(
                    sensorDTO.getSensorId(),
                    sensorDTO.getRoomNo(),
                    sensorDTO.getFloorNo(),
                    sensorDTO.getCo2Level()
            );

            boolean isSaved = sensorRepository.save(sensor);
            session.getTransaction().commit();

            return isSaved;
        }
    }

    @Override
    public boolean updateSensor(SensorDTO sensorDTO) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            sensorRepository.setSession(session);

            Sensor sensor = new Sensor(
                    sensorDTO.getSensorId(),
                    sensorDTO.getRoomNo(),
                    sensorDTO.getFloorNo(),
                    sensorDTO.getCo2Level()
            );

            boolean isUpdated = sensorRepository.update(sensor);
            session.getTransaction().commit();

            return isUpdated;
        }
    }

    @Override
    public boolean deleteSensor(String sensorID) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            sensorRepository.setSession(session);
            session.beginTransaction();

            Sensor sensor = sensorRepository.findById(sensorID);
            if (sensor != null){
                sensorRepository.delete(sensor);
                session.getTransaction().commit();

                return true;
            }
            return false;
        }
    }

    @Override
    public SensorDTO getSensorByID(String sensorID) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            sensorRepository.setSession(session);
            session.beginTransaction();

            Sensor sensor = sensorRepository.findById(sensorID);
            session.getTransaction().commit();

            if (sensor != null){
                return new SensorDTO(
                        sensor.getSensorID(),
                        sensor.getRoomNo(),
                        sensor.getFloorNo(),
                        sensor.getCo2Level()
                );
            }
            return null;
        }
    }

    @Override
    public List<SensorDTO> getAllSensors() throws Exception {
        return null;
    }
}
