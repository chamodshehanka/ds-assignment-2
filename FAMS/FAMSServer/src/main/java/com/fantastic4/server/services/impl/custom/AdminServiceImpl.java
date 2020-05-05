package com.fantastic4.server.services.impl.custom;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.common.services.custom.AdminService;
import com.fantastic4.common.services.custom.SensorService;
import com.fantastic4.server.business.BOFactory;
import com.fantastic4.server.business.custom.AdminBO;
import com.fantastic4.server.business.custom.SensorBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AdminServiceImpl extends UnicastRemoteObject implements AdminService{

    private final AdminBO adminBO;

    public AdminServiceImpl() throws RemoteException {
        adminBO = (AdminBO) BOFactory.getInstance()
                .getBOFactory(BOFactory.BOTypes.ADMIN);
    }



    @Override
    public boolean addAdmin(AdminDTO adminDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAdmin(String adminID) throws Exception {
        return false;
    }

    @Override
    public AdminDTO findAdminByID(String adminID) throws Exception {
        return null;
    }

    @Override
    public List<AdminDTO> getAllAdmins() throws Exception {
        return null;
    }

    @Override
    public boolean login(AdminDTO adminDTO) throws Exception {
        return adminBO.login(adminDTO);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return false;
    }

    @Override
    public boolean release(Object id) throws Exception {
        return false;
    }
}
