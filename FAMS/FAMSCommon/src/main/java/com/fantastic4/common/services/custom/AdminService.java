package com.fantastic4.common.services.custom;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.common.dto.SensorDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.common.services.SuperService;

import java.util.List;

public interface AdminService extends SuperService{
    boolean addAdmin(AdminDTO adminDTO) throws Exception;

    boolean updateAdmin(AdminDTO adminDTO) throws Exception;

    boolean deleteAdmin(String adminID) throws Exception;

    AdminDTO findAdminByID(String adminID) throws Exception;

    List<AdminDTO> getAllAdmins() throws Exception;

    boolean login(AdminDTO adminDTO) throws Exception;
}
