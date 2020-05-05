package com.fantastic4.restapi.controller;

import com.fantastic4.restapi.dto.Admin;
import com.fantastic4.restapi.service.FirebaseInitialize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminController {

    FirebaseInitialize firebaseInitialize = new FirebaseInitialize();

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

    @PutMapping("/login")
    public String login(@RequestBody Admin admin) throws ExecutionException, InterruptedException {
        return firebaseInitialize.login(admin);
    }

}
