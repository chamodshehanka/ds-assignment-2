package com.fantastic4.server.business.custom.impl;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.server.business.custom.AdminBO;
import com.fantastic4.server.repository.RepositoryFactory;
import com.fantastic4.server.repository.custom.AdminRepository;

import java.util.List;

public class AdminBOImpl implements AdminBO {

    private final AdminRepository adminRepository;

    public AdminBOImpl() {
        adminRepository = (AdminRepository) RepositoryFactory.getInstance()
                .getRepository(RepositoryFactory.RepositoryFactoryTypes.ADMIN);
    }

    @Override
    public boolean addAdmin(AdminDTO adminDTO) throws Exception {
        return adminRepository.save(adminDTO);
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO) throws Exception {
        return adminRepository.update(adminDTO);
    }

    @Override
    public boolean deleteAdmin(String adminID) throws Exception {
        return adminRepository.delete(adminID);
    }

    @Override
    public AdminDTO findAdminByID(String adminID) throws Exception {
        return adminRepository.findById(adminID);
    }

    @Override
    public List<AdminDTO> getAllAdmins() throws Exception {
        return adminRepository.findAll();
    }

    @Override
    public boolean login(AdminDTO adminDTO) throws Exception {
        return adminRepository.login(adminDTO);
    }
}
