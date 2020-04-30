package com.fantastic4.server.startup;

import com.fantastic4.server.resources.HibernateUtil;
import com.fantastic4.server.services.impl.ServicesFactoryImpl;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStart {
    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        try {
            if (HibernateUtil.getSessionFactory().isOpen()) {
                Registry registry = LocateRegistry.createRegistry(5050);
                registry.rebind("rentLio", ServicesFactoryImpl.getInstance());

                System.out.println("Server has been started successfully");
            } else {
                JOptionPane.showMessageDialog(null, "sql Saver is not connected", "Error", 1);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
