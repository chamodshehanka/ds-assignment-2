package com.fantastic4.server.startup;

import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.services.custom.SensorService;
import com.fantastic4.server.services.impl.ServicesFactoryImpl;
import com.fantastic4.server.services.impl.custom.SensorServiceImpl;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ServerStart {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","localhost");
        System.setProperty("java.security.policy", "file:./server.policy");

//        System.setProperty("java.rmi.server.hostname","127.0.0.1");
//        System.setProperty("java.security.policy","security.policy");
//        System.setSecurityManager(new RMISecurityManager());
        try {
            if (true) {
//                if(System.getSecurityManager() == null ){
//                    System.setSecurityManager( new RMISecurityManager() );
//                }
                Registry registry = LocateRegistry.createRegistry(5050);
                registry.rebind("fams", ServicesFactoryImpl.getInstance());
                System.out.println("Server has been started successfully");
                SensorServiceImpl sensorService = new SensorServiceImpl();
                System.out.println(sensorService.deleteSensor("S003"));
            } else {
                JOptionPane.showMessageDialog(null,
                        "API is not connected", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
