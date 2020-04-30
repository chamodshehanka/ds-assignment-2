package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.SensorDTO;
import com.fantastic4.restapi.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class SensorController {

    @Autowired
    FirebaseService firebaseService;

    @PostMapping("/createSensor")
    public String addSensor(@RequestBody SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        return firebaseService.addSensorData(sensorDTO);
    }

    @PutMapping("/deleteSensor")
    public String removeSensor(String sensorID) {
        return null;
    }
}
