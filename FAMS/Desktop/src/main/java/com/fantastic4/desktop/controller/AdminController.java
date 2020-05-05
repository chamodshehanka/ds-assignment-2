package com.fantastic4.desktop.controller;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.services.ServicesFactory;
import com.fantastic4.common.services.custom.AdminService;
import com.fantastic4.common.services.custom.SensorService;
import com.fantastic4.desktop.proxy.ProxyHandler;

import java.util.List;

public class AdminController {

    private static AdminService adminService;

    public static boolean createAdmin(AdminDTO adminDTO) throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.addAdmin(adminDTO);
    }

    public static boolean updateAdmin(AdminDTO adminDTO) throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.updateAdmin(adminDTO);
    }

    public static boolean deleteAdmin(String adminID) throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.deleteAdmin(adminID);
    }

    public static List<AdminDTO> getAllAdmins() throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.getAllAdmins();
    }

    public static AdminDTO findAdmin(String adminID) throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.findAdminByID(adminID);
    }

    public static boolean login(AdminDTO adminDTO) throws Exception {
        adminService = (AdminService) ProxyHandler.getInstance()
                .getService(ServicesFactory.ServicesType.ADMIN);

        return adminService.login(adminDTO);
    }

}
