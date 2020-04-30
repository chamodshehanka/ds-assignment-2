package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.SensorDTO;
import com.fantastic4.restapi.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class SensorController {

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/createSensor")
    public String addSensor(@RequestBody SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        System.out.println("Sensor ID : "+sensorDTO.getSensorId());
        return firebaseService.addSensorData(sensorDTO);
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
        return null;
    }

    @GetMapping("/getAllSensors")
    public ArrayList<SensorDTO> getAllSensors() {
        return null;
    }
}
