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
    public String removeSensor(@RequestBody String sensorID) {
        return null;
    }

    @PutMapping("/updateSensor")
    public String updateSensor(@RequestBody SensorDTO sensorDTO) {
        return null;
    }

    @GetMapping("/getSensor")
    public SensorDTO getSensor(@RequestBody String sensorID) {
        return firebaseInitialize.getSensor(sensorID);
    }

    @GetMapping("/getAllSensors")
    public ArrayList<SensorDTO> getAllSensors() {
        return null;
    }
}
