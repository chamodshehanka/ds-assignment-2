package com.fantastic4.server.business.custom;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.server.business.SuperBO;

import java.util.List;

public interface AdminBO extends SuperBO {

    boolean addAdmin(AdminDTO adminDTO) throws Exception;

    boolean updateAdmin(AdminDTO adminDTO) throws Exception;

    boolean deleteAdmin(String adminID) throws Exception;

    AdminDTO findAdminByID(String adminID) throws Exception;

    List<AdminDTO> getAllAdmins() throws Exception;

    AdminDTO login(AdminDTO adminDTO) throws Exception;
}
