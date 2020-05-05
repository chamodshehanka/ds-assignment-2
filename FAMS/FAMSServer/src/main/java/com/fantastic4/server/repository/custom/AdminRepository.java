package com.fantastic4.server.repository.custom;

import com.fantastic4.common.dto.AdminDTO;
import com.fantastic4.common.dto.SensorDataDTO;
import com.fantastic4.server.repository.SuperRepository;

import java.io.IOException;
import java.util.List;

public interface AdminRepository extends SuperRepository<AdminDTO, String> {

    boolean login(AdminDTO adminDTO) throws Exception;
}
