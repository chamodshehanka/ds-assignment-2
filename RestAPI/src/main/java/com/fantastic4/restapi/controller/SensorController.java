package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.Admin;
import com.fantastic4.restapi.dto.Room;
import com.fantastic4.restapi.dto.Sensor;
import com.fantastic4.restapi.dto.SensorData;
import com.fantastic4.restapi.service.FirebaseInitialize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@RestController
public class SensorController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

    @PostMapping("/createSensor")
    public String addSensor(@RequestBody Sensor sensor) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addSensor(sensor);
    }

    @DeleteMapping("/deleteSensor")
    public String removeSensor(@RequestBody String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteSensor(sensorID);
    }

    @PutMapping("/updateSensor")
    public String updateSensor(@RequestBody Sensor sensor) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateSensor(sensor);
    }

    @GetMapping("/getSensor")
    public Sensor getSensor(@RequestBody String sensorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getSensorByID(sensorID);
    }

    @GetMapping("/getAllSensors")
    public ArrayList<Sensor> getAllSensors() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllSensors();
    }

    @PostMapping("/createRoom")
    public String addRoom(@RequestBody Room room) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addRoom(room);
    }

    @DeleteMapping("/deleteRoom")
    public String deleteRoom(@RequestParam String roomID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteRoom(roomID);
    }

    @PutMapping("/updateRoom")
    public String updateRoom(@RequestBody Room room) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateRoom(room);
    }

    @GetMapping("/getRoom")
    public Room getRoom(@RequestParam String roomID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getRoomByID(roomID);
    }

    @GetMapping("/getAllRooms")
    public ArrayList<Room> getAllRooms() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllRooms();
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

    @PostMapping("/createAdmin")
    public String createAdmin(@RequestBody Admin admin) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam String id) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteAdmin(id);
    }

    @PutMapping("/updateAdmin")
    public String updateAdmin(@RequestBody Admin admin) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateAdmin(admin);
    }

    @GetMapping("/getAdmin")
    public Admin getAdmin(@RequestParam String id) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAdminByID(id);
    }

    @GetMapping("/getAllAdmins")
    public ArrayList<Admin> getAllAdmins() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllAdmins();
    }

}
