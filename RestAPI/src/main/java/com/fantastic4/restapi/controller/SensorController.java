package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.Sensor;
import com.fantastic4.restapi.dto.SensorData;
import com.fantastic4.restapi.service.FirebaseInitialize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SensorController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

    @PostMapping("/createSensor")
    public String addSensor(@RequestBody Sensor sensor) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addSensor(sensor);
    }

    @DeleteMapping("/deleteSensor")
    public String removeSensor(@RequestParam String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteSensor(sensorID);
    }

    @PutMapping("/updateSensor")
    public String updateSensor(@RequestBody Sensor sensor) throws ExecutionException, InterruptedException {
        System.out.println(sensor.getSensorID());
        return firebaseInitialize.updateSensor(sensor);
    }

    @GetMapping("/getSensor")
    public Sensor getSensor(@RequestParam String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getSensorByID(sensorID);
    }

    @GetMapping("/getAllSensors")
    public ArrayList<Sensor> getAllSensors() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllSensors();
    }

    @PostMapping("/createSensorData")
    public String createSensorData(SensorData sensorData) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addSensorData(sensorData);
    }

    @DeleteMapping("/deleteSensorData")
    public String deleteSensorData(@RequestParam String id) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteSensorData(id);
    }

    @PutMapping("/updateSensorData")
    public String updateSensorData(@RequestBody SensorData sensorData) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateSensorData(sensorData);
    }

    @GetMapping("/getSensorData")
    public SensorData getSensorData(@RequestParam String id) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getSensorDataByID(id);
    }

    @GetMapping("/getAllSensorData")
    public ArrayList<SensorData> getAllSensorData() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllSensorData();
    }

    @GetMapping("/getAllLatestSensorData")
    public ArrayList<SensorData> getAllLatestSensorData() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllLatestSensorData();
    }

}
