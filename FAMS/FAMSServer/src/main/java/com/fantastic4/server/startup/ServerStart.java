package com.fantastic4.server.startup;

import com.fantastic4.server.services.impl.ServicesFactoryImpl;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStart {
    public static void main(String[] args){
//        System.setProperty("java.rmi.server.hostname","127.0.0.1");
//        System.setProperty("java.security.policy","security.policy");
//        System.setSecurityManager(new RMISecurityManager());
        try {
            if (true) {
                Registry registry = LocateRegistry.createRegistry(5050);
                registry.rebind("fams", ServicesFactoryImpl.getInstance());
                System.out.println("Server has been started successfully");
            } else {
                JOptionPane.showMessageDialog(null,
                        "API is not connected", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
