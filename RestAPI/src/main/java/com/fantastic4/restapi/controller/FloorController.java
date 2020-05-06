package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.Floor;
import com.fantastic4.restapi.service.FirebaseInitialize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FloorController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

    @PostMapping("/createFloor")
    public String addFloor(@RequestBody Floor floor) throws ExecutionException, InterruptedException {
        return firebaseInitialize.addFloor(floor);
    }

    @DeleteMapping("/deleteFloor")
    public String deleteFloor(@RequestParam String floorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.deleteFloor(floorID);
    }

    @PutMapping("/updateFloor")
    public String updateFloor(@RequestBody Floor floor) throws ExecutionException, InterruptedException {
        return firebaseInitialize.updateFloor(floor);
    }

    @GetMapping("/getFloor")
    public Floor getFloor(@RequestParam String floorID) throws ExecutionException, InterruptedException {
        return firebaseInitialize.getFloorByID(floorID);
    }

    @GetMapping("/getAllFloors")
    public ArrayList<Floor> getAllFloors() throws ExecutionException, InterruptedException {
        return firebaseInitialize.getAllFloors();
    }

}