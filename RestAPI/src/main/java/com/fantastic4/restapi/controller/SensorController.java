package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.SensorDTO;
import com.fantastic4.restapi.service.FirebaseInitialize;
import com.fantastic4.restapi.service.FirebaseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class SensorController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

    @PostMapping("/createSensor")
    public String addSensor(@RequestBody SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addSensorData(sensorDTO);
    }

    @DeleteMapping("/deleteSensor")
    public String removeSensor(@RequestBody String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteSensorData(sensorID);
    }

    @PutMapping("/updateSensor")
    public String updateSensor(@RequestBody SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateSensorData(sensorDTO);
    }

    @GetMapping("/getSensor")
    public SensorDTO getSensor(@RequestBody String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getSensorByID(sensorID);
    }

    @GetMapping("/getAllSensors")
    public ArrayList<SensorDTO> getAllSensors() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllSensors();
    }
}
