package com.fantastic4.server.repository.custom;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.server.repository.SuperRepository;

import java.io.IOException;
import java.util.List;

public interface SensorRepository extends SuperRepository<SensorDTO, String> {

    List<SensorDataDTO> getSensorData(String sensorID) throws IOException, InterruptedException;
}
