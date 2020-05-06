package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.Room;
import com.fantastic4.restapi.service.FirebaseInitialize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RoomController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

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
}